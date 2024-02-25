package quizApplication.ExamQuiz.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import quizApplication.ExamQuiz.config.EmailDetails;
import quizApplication.ExamQuiz.config.JwtUtil;
import quizApplication.ExamQuiz.dao.RoleRepository;
import quizApplication.ExamQuiz.dao.UserRepository;
import quizApplication.ExamQuiz.entity.LoginRequest;
import quizApplication.ExamQuiz.entity.LoginResponse;
import quizApplication.ExamQuiz.entity.Role;
import quizApplication.ExamQuiz.entity.User;
import quizApplication.ExamQuiz.service.AuthServices;
import quizApplication.ExamQuiz.service.EmailService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    EmailService emailService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public User signup(User user) throws Exception {

        //TODO fetch data from database by username, if user already present then throw exception.

        User user1 = userRepository.findByUsername(user.getUsername());
        if(user1 != null)
        {
            throw new Exception("User already present with this username");
        }

        Random random = new Random();
        user.setOtp(random.nextInt(1000));

        Role role = roleRepository.findById("USER").isPresent() ? roleRepository.findById("USER").get() : null;
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRoles(userRoles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

//        emailDetails.setRecipient("tushar");
//        emailDetails.setSubject("verification");
//        emailDetails.setMsgBody("Hello user");

       /* String msgBody = "<html><h1> Hello "+user.getFirstName()+", your email verification OTP is "+user.getOtp()+"</h1></html>";

        emailService.sendSimpleMail(EmailDetails.builder().recipient(user.getUsername())
                .subject("Email verification").msgBody(msgBody).build());*/



        User user2 = userRepository.save(user);

        return user2;


    }

    public LoginResponse login(LoginRequest loginRequest) throws Exception {

        authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(loginRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return new LoginResponse(userRepository.findByUsername(loginRequest.getUsername()), token);

    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    public User verifyOTP(int userOTP, int id) {

        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            User user1 = user.get();
            if(userOTP == user1.getOtp()){
                user1.setActive(true);
                String msgBody = "Hello "+user1.getFirstName()+", your otp" +user1.getOtp()+ " is verified successfully ";

                emailService.sendSimpleMail(EmailDetails.builder().recipient(user1.getUsername())
                        .subject("Email verification").msgBody(msgBody).build());
                userRepository.save(user1);
            }
        }
       return null;
    }




}

package quizApplication.ExamQuiz.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import quizApplication.ExamQuiz.entity.LoginRequest;
import quizApplication.ExamQuiz.entity.LoginResponse;
import quizApplication.ExamQuiz.entity.User;
import quizApplication.ExamQuiz.service.AuthServices;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {
    @Autowired
    AuthServices authServices;

    @PostMapping(value = "/register")
    public User signup(@RequestBody User user) throws Exception{

        return authServices.signup(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception {

        return authServices.login(loginRequest);
    }

    @PostMapping("/verifyOTP")
    public ResponseEntity<User> verifyOTP(@RequestParam int userOTP, @RequestParam int id){

        User user = authServices.verifyOTP(userOTP, id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}

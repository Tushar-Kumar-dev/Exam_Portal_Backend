package quizApplication.ExamQuiz.service;

import org.springframework.stereotype.Service;
import quizApplication.ExamQuiz.entity.LoginRequest;
import quizApplication.ExamQuiz.entity.LoginResponse;
import quizApplication.ExamQuiz.entity.User;

public interface AuthServices {

      User signup(User user) throws Exception;

      LoginResponse login(LoginRequest loginRequest) throws Exception;

      User verifyOTP(int UserOTP, int id);


}

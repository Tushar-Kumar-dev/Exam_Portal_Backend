package quizApplication.ExamQuiz.service;

import quizApplication.ExamQuiz.config.EmailDetails;

public interface EmailService {

    String sendSimpleMail(EmailDetails details);
}
    
package quizApplication.ExamQuiz.service;

import quizApplication.ExamQuiz.entity.QuizResult;

import java.util.List;

public interface QuizResultService {

    QuizResult submitQuiz(QuizResult quizResult);

    List<QuizResult> getQuizResultByUser(Long UserId);

    List<QuizResult> getQuizResult();
}

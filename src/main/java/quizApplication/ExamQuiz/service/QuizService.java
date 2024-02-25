package quizApplication.ExamQuiz.service;

import quizApplication.ExamQuiz.entity.Category;
import quizApplication.ExamQuiz.entity.Quiz;

import java.util.List;

public interface QuizService {

    Quiz addQuiz(Quiz quiz);
    List<Quiz> getQuizzes();

    Quiz getQuiz(Long quizId);
    Quiz updateQuiz(Long quizId, Quiz quiz);

    void deleteQuiz(Long quizId);

    List<Quiz> getQuizByCategory(Category category);

}

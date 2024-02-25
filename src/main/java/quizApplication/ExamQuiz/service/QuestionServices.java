package quizApplication.ExamQuiz.service;

import quizApplication.ExamQuiz.entity.Question;
import quizApplication.ExamQuiz.entity.Quiz;

import java.util.List;

public interface QuestionServices {


    Question addQuestion(Question question);
    List<Question> getQuestiones();

    Question getQuestion(Long quesId);
    Question updateQuestion(Long queId, Question question);

    void deleteQuestion(Long queId);

}

package quizApplication.ExamQuiz.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import quizApplication.ExamQuiz.dao.QuestionRepositry;
import quizApplication.ExamQuiz.dao.QuizRepositry;
import quizApplication.ExamQuiz.entity.Question;
import quizApplication.ExamQuiz.entity.Quiz;
import quizApplication.ExamQuiz.service.QuestionServices;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionServices {

    @Autowired
    QuestionRepositry questionRepositry;

    @Autowired
    QuizRepositry quizRepositry;

    public Question addQuestion(Question question){
        Quiz quiz = quizRepositry.findById(question.getQuiz().getQuizId()).get();
        quiz.setNumOfQuestions(quiz.getNumOfQuestions()+1);
        quizRepositry.save(quiz);
        return questionRepositry.save(question);
    }

    public List<Question> getQuestiones(){
        return questionRepositry.findAll();
    }

    public Question getQuestion(Long queId){
        return questionRepositry.findById(queId).isPresent()? questionRepositry.findById(queId).get():null;
    }

    public Question updateQuestion(Long queId, Question question){
        Question question1 = getQuestion(queId);
        question1.setOption1(question.getOption1());
        question1.setOption2(question.getOption2());
        question1.setOption3(question.getOption3());
        question1.setContent(question.getContent());
        return question1;
    }

    public void deleteQuestion(Long queId){
        questionRepositry.delete(getQuestion(queId));
    }





}

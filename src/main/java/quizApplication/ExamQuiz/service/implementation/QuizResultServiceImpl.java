package quizApplication.ExamQuiz.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quizApplication.ExamQuiz.dao.QuizResultRepositry;
import quizApplication.ExamQuiz.entity.QuizResult;
import quizApplication.ExamQuiz.service.QuizResultService;

import java.util.List;

@Service
public class QuizResultServiceImpl implements QuizResultService {

    @Autowired
    QuizResultRepositry quizResultRepositry;

    public QuizResult submitQuiz(QuizResult quizResult){
        return  quizResultRepositry.save(quizResult);
    }

    public List<QuizResult> getQuizResultByUser(Long userId){
        return quizResultRepositry.findByUserId(userId);
    }

    public List<QuizResult> getQuizResult(){
        return quizResultRepositry.findAll();
    }



}

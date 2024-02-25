package quizApplication.ExamQuiz.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quizApplication.ExamQuiz.dao.CategoryRepositry;
import quizApplication.ExamQuiz.dao.QuizRepositry;
import quizApplication.ExamQuiz.entity.Category;
import quizApplication.ExamQuiz.entity.Quiz;
import quizApplication.ExamQuiz.service.QuizService;

import java.util.List;
import java.util.Optional;
@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepositry quizRepositry;

    public Quiz addQuiz(Quiz quiz){
        return quizRepositry.save(quiz);
    }

    public List<Quiz> getQuizzes(){
        return quizRepositry.findAll();
    }

    public Quiz getQuiz(Long quizId){
        Optional<Quiz> quiz = quizRepositry.findById(quizId);
        if(quiz.isPresent()){
            Quiz quiz1 = quiz.get();
            return quiz1;
        }
        return null;
    }

    public Quiz updateQuiz(Long quizId, Quiz quiz){

        Quiz quiz1 = getQuiz(quizId);
        quiz1.setTitle(quiz.getTitle());
        quiz1.setDescription(quiz.getDescription());
        quiz1.setMaxMarks(quiz.getMaxMarks());
        return quiz1;
    }

    public void deleteQuiz(Long quizId){
            quizRepositry.deleteById(quizId);
        }


    public List<Quiz> getQuizByCategory(Category category){

        List<Quiz> quiz = quizRepositry.findByCategory(category);
        return quiz;
    }

    }



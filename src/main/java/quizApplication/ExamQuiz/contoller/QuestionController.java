package quizApplication.ExamQuiz.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import quizApplication.ExamQuiz.dao.QuizRepositry;
import quizApplication.ExamQuiz.entity.Question;
import quizApplication.ExamQuiz.entity.Quiz;
import quizApplication.ExamQuiz.service.QuestionServices;
import quizApplication.ExamQuiz.service.QuizService;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    QuestionServices questionServices;

    @Autowired
    QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionServices.addQuestion(question));
    }

    @GetMapping("/")
    public ResponseEntity<List<Question>> getQuestiones(){
        return ResponseEntity.ok(questionServices.getQuestiones());
    }

    @GetMapping("/{quesId}")

    public ResponseEntity<Question> getQuestion(@PathVariable Long quesId){
        return ResponseEntity.ok(questionServices.getQuestion(quesId));
    }

    @GetMapping(value = "/", params = "quizId")
    public ResponseEntity<Set<Question>> getQuestionByQuiz(@RequestParam Long quizId){
        Quiz quiz = quizService.getQuiz(quizId);

        Set<Question> questions = quiz.getQuestions();
        return ResponseEntity.ok(questions);
    }

    @PutMapping("/{queId}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long queId, @RequestBody Question question){
            if(questionServices.getQuestion(queId) != null){
                return ResponseEntity.ok(questionServices.updateQuestion(queId,question));
            }
            return null;
    }

    @DeleteMapping("/{queId}")
    public void deleteQuestion(@PathVariable Long queId){
        questionServices.deleteQuestion(queId);
        ResponseEntity.ok(true);
    }
}



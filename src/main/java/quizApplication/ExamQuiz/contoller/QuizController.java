package quizApplication.ExamQuiz.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import quizApplication.ExamQuiz.entity.Category;
import quizApplication.ExamQuiz.entity.Quiz;
import quizApplication.ExamQuiz.service.CategoryService;
import quizApplication.ExamQuiz.service.QuizService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    CategoryService categoryService;
    @PostMapping("/")
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    @GetMapping("/")
    public ResponseEntity<List<Quiz>> getQuizzes() {
        List<Quiz> quiz = quizService.getQuizzes();
        return ResponseEntity.status(HttpStatus.OK).body(quiz);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable Long quizId){
        Quiz quiz = quizService.getQuiz(quizId);
        return ResponseEntity.status(HttpStatus.OK).body(quiz);
    }

    @PutMapping("/{quizId}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long quizId, @RequestBody Quiz quiz){
        Quiz quiz1 = quizService.updateQuiz(quizId, quiz);
        return ResponseEntity.status(HttpStatus.OK).body(quiz1);
    }

    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable Long quizId){
         quizService.deleteQuiz(quizId);
         ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @GetMapping(value = "/" , params = "catId")
    public ResponseEntity<List<Quiz>> getQuizByCategory(@RequestParam Long catId){
        Category category = categoryService.getCategory(catId);
        List<Quiz> quiz = quizService.getQuizByCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(quiz);
    }
}

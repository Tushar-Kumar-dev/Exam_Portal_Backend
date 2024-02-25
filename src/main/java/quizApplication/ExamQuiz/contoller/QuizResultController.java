package quizApplication.ExamQuiz.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quizApplication.ExamQuiz.entity.Question;
import quizApplication.ExamQuiz.entity.Quiz;
import quizApplication.ExamQuiz.entity.QuizResult;
import quizApplication.ExamQuiz.service.QuestionServices;
import quizApplication.ExamQuiz.service.QuizResultService;
import quizApplication.ExamQuiz.service.QuizService;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/quizResult")
public class QuizResultController {

    @Autowired
    QuizService quizService;

    @Autowired
    QuizResultService quizResultService;

    @Autowired
    QuestionServices questionServices;


    @PostMapping(value = "/submit", params = {"userId", "quizId"})
    public ResponseEntity<QuizResult> submitQuiz(@RequestParam Long userId, @RequestParam Long quizId, @RequestBody Map<String, String> answers){

        Quiz quiz = quizService.getQuiz(quizId);
        int totalQuestion = quiz.getNumOfQuestions();
        int maxMarks = quiz.getMaxMarks();

        int marksPerQuestion = 5;


        Question question = null;

        int totalNumOfRightAnswer = 0;

        for(Map.Entry<String, String> m : answers.entrySet()){
            Long queId = Long.valueOf(m.getKey());
            question = questionServices.getQuestion(queId);
            if(question != null){
                if(question.getAnswer().equals(m.getValue())){
                    totalNumOfRightAnswer++;
                }
            }
        }

        float totalObtainMarks = totalNumOfRightAnswer * marksPerQuestion;

        QuizResult quizResult = new QuizResult();
        quizResult.setUserId(userId);
        quizResult.setQuiz(quizService.getQuiz(quizId));
        quizResult.setTotalObtainedMarks(totalObtainMarks);
        final ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        quizResult.setAttemptDatetime(now.toLocalDate().toString() + " " + now.toLocalTime().toString().substring(0,8));
        return ResponseEntity.ok(quizResultService.submitQuiz(quizResult));
    }

    @GetMapping(value = "/", params = "userId")
    public ResponseEntity<List<QuizResult>> getQuizResult(@RequestParam Long userId){
        List<QuizResult> quizResultList = quizResultService.getQuizResultByUser(userId);
        Collections.reverse(quizResultList);
        return ResponseEntity.ok(quizResultList);
    }


    @GetMapping(value = "/all")
    public ResponseEntity<List<QuizResult>> getQuizResult(){
        List<QuizResult> quizResultList = quizResultService.getQuizResult();
        Collections.reverse(quizResultList);
        return ResponseEntity.ok(quizResultList);
    }

}

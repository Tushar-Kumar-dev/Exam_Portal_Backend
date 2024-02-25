package quizApplication.ExamQuiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import quizApplication.ExamQuiz.entity.QuizResult;

import java.util.List;

public interface QuizResultRepositry extends JpaRepository<QuizResult, Long> {
    List<QuizResult> findByUserId(Long userId);
}

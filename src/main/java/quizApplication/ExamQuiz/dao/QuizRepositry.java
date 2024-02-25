package quizApplication.ExamQuiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import quizApplication.ExamQuiz.entity.Category;
import quizApplication.ExamQuiz.entity.Quiz;

import java.util.List;

public interface QuizRepositry extends JpaRepository<Quiz, Long> {
    List<Quiz> findByCategory(Category category);
}

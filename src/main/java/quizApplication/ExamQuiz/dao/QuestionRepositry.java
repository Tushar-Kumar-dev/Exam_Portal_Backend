package quizApplication.ExamQuiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import quizApplication.ExamQuiz.entity.Question;

public interface QuestionRepositry extends JpaRepository<Question, Long> {
}

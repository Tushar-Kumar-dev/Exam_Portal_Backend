package quizApplication.ExamQuiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quizApplication.ExamQuiz.entity.Category;

@Repository
public interface CategoryRepositry extends JpaRepository<Category, Long> {

}

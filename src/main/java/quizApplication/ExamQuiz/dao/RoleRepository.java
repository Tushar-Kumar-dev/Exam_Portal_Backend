package quizApplication.ExamQuiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quizApplication.ExamQuiz.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}

package quizApplication.ExamQuiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quizApplication.ExamQuiz.entity.LoginRequest;
import quizApplication.ExamQuiz.entity.LoginResponse;
import quizApplication.ExamQuiz.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByPasswordAndUsername(String password, String username);

    User findByUsername(String username);
}

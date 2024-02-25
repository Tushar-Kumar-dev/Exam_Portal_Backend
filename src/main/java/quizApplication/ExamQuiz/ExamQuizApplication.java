package quizApplication.ExamQuiz;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import quizApplication.ExamQuiz.dao.RoleRepository;
import quizApplication.ExamQuiz.entity.Role;

import java.util.Arrays;

@SpringBootApplication
public class ExamQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamQuizApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializer(RoleRepository roleRepository) {
		return args -> roleRepository.saveAll(Arrays.asList(
				Role.builder().roleName("USER").roleDescription("Default Role provided to each user").build(),
				Role.builder().roleName("ADMIN").roleDescription("Superuser, who has access for all functionality").build()));
	}

}

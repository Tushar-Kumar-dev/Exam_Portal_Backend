package quizApplication.ExamQuiz.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "quiz_result")
public class QuizResult {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long quizResId;

        @Column(name = "user_id")
        private Long userId;

        @Column(name = "total_obtained_marks")
        private float totalObtainedMarks;

        @Column(name = "attempt_datetime")
        private String attemptDatetime;

        @ManyToOne(fetch = FetchType.EAGER)
        private Quiz quiz;

}

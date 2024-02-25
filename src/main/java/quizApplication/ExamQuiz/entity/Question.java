package quizApplication.ExamQuiz.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "question")
public class Question {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long quesId;

        @Column(name = "question", length = 5000)
        private String content;

        @Column(name = "image")
        private String image;

        @Column(name = "option1")
        private String option1;

        @Column(name = "option2")
        private String option2;

        @Column(name = "option3")
        private String option3;

        @Column(name = "option4")
        private String option4;

        @Column(name = "answer")
        private String answer;

        @ManyToOne(fetch = FetchType.EAGER)
        private Quiz quiz;
}

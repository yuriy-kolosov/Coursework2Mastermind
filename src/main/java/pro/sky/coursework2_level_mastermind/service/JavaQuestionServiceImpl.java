package pro.sky.coursework2_level_mastermind.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.coursework2_level_mastermind.domain.JavaExam;
import pro.sky.coursework2_level_mastermind.domain.JavaExamImpl;
import pro.sky.coursework2_level_mastermind.domain.Question;
import pro.sky.coursework2_level_mastermind.repository.JavaQuestionRepository;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements JavaQuestionService {

    private final JavaQuestionRepository javaQuestionRepository;
    public JavaExam javaExam = new JavaExamImpl();

    public JavaQuestionServiceImpl() {
        this.javaQuestionRepository = new JavaQuestionRepository(new JavaExamImpl());
    }

    public JavaQuestionServiceImpl(JavaExam javaExam) {
        this.javaExam = javaExam;
        this.javaQuestionRepository = new JavaQuestionRepository(javaExam);
    }

    @PostConstruct
    public void init() {
        JavaExam javaExam = new JavaExamImpl();
        int javaQuestionSizeNew = 5;
        while (javaQuestionRepository.getJavaQuestionSize() < javaQuestionSizeNew) {
            Random javaExamTicketChoice = new Random();
            int javaExamTicketIdChoice = (int) (10 * javaExamTicketChoice.nextDouble());
            Question javaExamQuestion = new Question(javaQuestionRepository.javaExam
                    .getJavaExamQuestion(javaExamTicketIdChoice)
                    , javaQuestionRepository.javaExam
                    .getJavaExamAnswer(javaExamTicketIdChoice));
            add(javaExamQuestion);
        }
    }

    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    public Collection<Question> getRandom(int amount) {
        return javaQuestionRepository.getRandom(amount);
    }

    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    public Collection<Question> getNewSet(int amount) {
        return javaQuestionRepository.getNewSet(amount);
    }

}

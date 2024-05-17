package pro.sky.coursework2_level_mastermind.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2_level_mastermind.domain.Question;

import java.util.Collection;

@Service
public class ExaminerServiceImpl implements JavaQuestionService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    public Question add(Question question) {
        return javaQuestionService.add(question);
    }

    public Question remove(Question question) {
        return javaQuestionService.remove(question);
    }

    public Collection<Question> getRandom(int amount) {
        return javaQuestionService.getRandom(amount);
    }

    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

    public Collection<Question> getNewSet(int amount) {
        return javaQuestionService.getNewSet(amount);
    }

}

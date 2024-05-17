package pro.sky.coursework2_level_mastermind.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2_level_mastermind.domain.Question;
import pro.sky.coursework2_level_mastermind.service.JavaQuestionService;
import pro.sky.coursework2_level_mastermind.service.MathQuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {

    private final JavaQuestionService javaQuestionService;

    private final MathQuestionService mathQuestionService;

    public ExamController(@Qualifier("examinerServiceImpl") JavaQuestionService javaQuestionService
            , MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;

    }

    @GetMapping(path = "/java/{amount}")
    public Collection<Question> getJavaQuestion(@PathVariable int amount) {
        return javaQuestionService.getNewSet(amount);
    }

    @GetMapping(path = "/math")
    public String getMathQuestion() {
        return mathQuestionService.genQuestion();
    }

    @GetMapping(path = "/math={answer}")
    public boolean getMathAnswer(@PathVariable int answer) {
        return mathQuestionService.genAnswer(answer);
    }

}

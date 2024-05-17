package pro.sky.coursework2_level_mastermind.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pro.sky.coursework2_level_mastermind.domain.Question;
import pro.sky.coursework2_level_mastermind.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(@Qualifier("javaQuestionServiceImpl") JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/java/add")
    public Question javaQuestionAdd(@RequestParam("question") String jQuestion,
                                    @RequestParam("answer") String jAnswer) {
        return javaQuestionService.add(new Question(jQuestion, jAnswer));
    }

    @GetMapping(path = "/java/remove")
    public Question javaQuestionRemove(@RequestParam("question") String jQuestion,
                                       @RequestParam("answer") String jAnswer) {
        return javaQuestionService.remove(new Question(jQuestion, jAnswer));
    }

    @GetMapping(path = "/java/find")
    public Collection<Question> javaQuestionFind() {
        return javaQuestionService.getAll();
    }

    @GetMapping(path = "/java/get/{amount}")
    public Collection<Question> getJavaQuestions(@PathVariable int amount) {
        return javaQuestionService.getRandom(amount);
    }

    @GetMapping(path = "/java")
    public Collection<Question> getAllQuestions() {
        return javaQuestionService.getAll();
    }

}

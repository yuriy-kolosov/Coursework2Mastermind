package pro.sky.coursework2_level_mastermind.service;

import pro.sky.coursework2_level_mastermind.domain.Question;

import java.util.Collection;

public interface JavaQuestionService {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getRandom(int amount);

    Collection<Question> getAll();

    Collection<Question> getNewSet(int amount);

}

package pro.sky.coursework2_level_mastermind.repository;

import pro.sky.coursework2_level_mastermind.domain.Question;

import java.util.Collection;

public interface QuestionRepository {

    int getJavaQuestionSize();

    Question add(Question question);

    Question remove(Question question);

    Question getRandomQuestion();

    Collection<Question> getRandom(int amount);

    Collection<Question> getAll();

    Collection<Question> getNewSet(int amount);

}

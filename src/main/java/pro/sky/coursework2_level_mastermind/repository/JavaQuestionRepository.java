package pro.sky.coursework2_level_mastermind.repository;

import pro.sky.coursework2_level_mastermind.domain.JavaExam;
import pro.sky.coursework2_level_mastermind.domain.Question;
import pro.sky.coursework2_level_mastermind.exception.AmountQuestionsExceeded;

import java.util.*;

public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> javaQuestion;
    private int javaQuestionSize;
    public final JavaExam javaExam;

    public JavaQuestionRepository(JavaExam javaExam) {
        this.javaExam = javaExam;
        this.javaQuestion = new HashSet<>();
        this.javaQuestionSize = 0;
    }

    public int getJavaQuestionSize() {
        return javaQuestionSize;
    }

    @Override
    public Question add(Question question) {
        if (javaQuestion.add(question)) {
            javaQuestionSize++;
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (javaQuestion.remove(question)) {
            javaQuestionSize--;
        }
        return question;
    }

    @Override
    public Question getRandomQuestion() {
        Question[] questionArrayTemp = getAll().toArray(new Question[javaQuestionSize]);
        return questionArrayTemp[javaExam.getJavaRandomId()];
    }

    @Override
    public Collection<Question> getRandom(int amount) {
        if (amount <= javaQuestionSize) {
            Set<Question> javaExamQuestionTempSet = new HashSet<Question>();
            int i = 0;
            while (i < amount) {
                if (javaExamQuestionTempSet.add(getRandomQuestion())) {
                    i++;
                }
            }
            return Collections.unmodifiableCollection(javaExamQuestionTempSet);
        } else {
            throw new AmountQuestionsExceeded("Превышено количество запрошенных вопросов из общего списка вопросов");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(javaQuestion);
    }

    @Override
    public Collection<Question> getNewSet(int amount) {
        if (amount <= javaExam.getJavaExamTicketNum()) {
            javaQuestion.clear();
            javaQuestionSize = 0;
            while (javaQuestionSize < amount) {
                Random javaExamTicketChoice = new Random();
                int javaExamTicketIdChoice = (int) (javaExam.getJavaExamTicketNum() * javaExamTicketChoice.nextDouble());
                Question javaExamQuestion = new Question(javaExam.getJavaExamQuestion(javaExamTicketIdChoice)
                        , javaExam.getJavaExamAnswer(javaExamTicketIdChoice));
                add(javaExamQuestion);
            }
            return Collections.unmodifiableCollection(javaQuestion);
        } else {
            throw new AmountQuestionsExceeded("Превышено число запросов в общем списке вопросов");
        }
    }

}

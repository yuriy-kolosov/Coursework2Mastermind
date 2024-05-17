package pro.sky.coursework2_level_mastermind.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pro.sky.coursework2_level_mastermind.domain.JavaExam;
import pro.sky.coursework2_level_mastermind.domain.JavaExamImpl;
import pro.sky.coursework2_level_mastermind.domain.MathExam;
import pro.sky.coursework2_level_mastermind.domain.MathExamImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExaminerServiceImplTest {

    //        Проверка работоспособности создания коллекции по запросу ExamController
    @Test
    void shouldGetNewSetCorrect() {
//        Подготовка
        JavaExam javaExam = new JavaExamImpl();
        JavaQuestionServiceImpl javaQuestionServiceImplRes = new JavaQuestionServiceImpl(javaExam);
//        final JavaQuestionRepository javaQuestionRepositoryRes = new JavaQuestionRepository(javaExam);
//        Выполнение
        assertEquals(1, javaQuestionServiceImplRes.getNewSet(1).size());
        assertEquals(3, javaQuestionServiceImplRes.getNewSet(3).size());
    }

    //        Проверка работоспособности генерации вопросов по математике "на лету" по запросу ExamController
    @Test
    void shouldGenQuestionCorrect() {
//        Подготовка
        MathExam mocMathExam = Mockito.spy(MathExamImpl.class);
        MathQuestionService mathQuestionServiceImplRes = new MathQuestionServiceImpl(mocMathExam);
//        Выполнение
        Mockito.when(mocMathExam.getMathRandomId()).thenReturn(0);
        assertEquals("2*2=", mathQuestionServiceImplRes.genQuestion());
    }

    @Test
    void shouldGenAnswerCorrect() {
//        Подготовка
        MathExam mocMathExam = Mockito.spy(MathExamImpl.class);
        MathQuestionService mathQuestionServiceImplRes = new MathQuestionServiceImpl(mocMathExam);
//        Выполнение
        Mockito.when(mocMathExam.getMathRandomId()).thenReturn(0);
        assertTrue(mathQuestionServiceImplRes.genAnswer(4));
    }

}

package pro.sky.coursework2_level_mastermind.service;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2_level_mastermind.domain.JavaExam;
import pro.sky.coursework2_level_mastermind.domain.JavaExamImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.coursework2_level_mastermind.constant.JavaQuestionServiceImplTestConstant.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceImplTest {

    //        Проверка работоспособности выполнения запросов JavaQuestionController
    @Test
    void shouldAddCorrect() {
//        Подготовка
        JavaExam javaExam = new JavaExamImpl();
        JavaQuestionServiceImpl javaQuestionServiceImplRes = new JavaQuestionServiceImpl(javaExam);
//        Выполнение
        assertEquals(JAVA_Q_TEST1, javaQuestionServiceImplRes.add(JAVA_Q_TEST1));
        assertEquals(1, javaQuestionServiceImplRes.getAll().size());
        MatcherAssert.assertThat(javaQuestionServiceImplRes.getAll(), Matchers.containsInAnyOrder(JAVA_Q_TEST1));
    }

    @Test
    void shouldRemoveCorrect() {
//        Подготовка
        JavaExam javaExam = new JavaExamImpl();
        JavaQuestionServiceImpl javaQuestionServiceImplRes = new JavaQuestionServiceImpl(javaExam);
        javaQuestionServiceImplRes.add(JAVA_Q_TEST1);
//        Выполнение
        assertEquals(JAVA_Q_TEST1, javaQuestionServiceImplRes.remove(JAVA_Q_TEST1));
        assertEquals(0, javaQuestionServiceImplRes.getAll().size());
    }

    @Test
    void shouldGetRandomCorrect() {
//        Подготовка
        JavaExam mocJavaExam = Mockito.spy(JavaExamImpl.class);
        JavaQuestionService javaQuestionServiceImplRes = new JavaQuestionServiceImpl(mocJavaExam);
//        Выполнение
        javaQuestionServiceImplRes.add(JAVA_Q_TEST1);
//        assertEquals(1, javaQuestionServiceImplRes.getAll().size());
        MatcherAssert.assertThat(javaQuestionServiceImplRes.getAll(), Matchers.containsInAnyOrder(JAVA_Q_TEST1));

        Mockito.when(mocJavaExam.getJavaRandomId()).thenReturn(0);
        MatcherAssert.assertThat(javaQuestionServiceImplRes.getRandom(1)
                , Matchers.containsInAnyOrder(JAVA_Q_TEST1));
    }

    @Test
    void shouldGetAllCorrect() {
//        Подготовка 1
        JavaExam javaExam = new JavaExamImpl();
        JavaQuestionServiceImpl javaQuestionServiceImplRes = new JavaQuestionServiceImpl(javaExam);
//        Выполнение 1
        javaQuestionServiceImplRes.add(JAVA_Q_TEST1);
        assertEquals(1, javaQuestionServiceImplRes.getAll().size());
        MatcherAssert.assertThat(javaQuestionServiceImplRes.getAll()
                , Matchers.containsInAnyOrder(JAVA_Q_TEST1));
//        Подготовка 2
        javaQuestionServiceImplRes.add(JAVA_Q_TEST2);
        javaQuestionServiceImplRes.add(JAVA_Q_TEST3);
//        Выполнение 2
        assertEquals(3, javaQuestionServiceImplRes.getAll().size());
        MatcherAssert.assertThat(javaQuestionServiceImplRes.getAll()
                , Matchers.containsInAnyOrder(JAVA_Q_TEST1, JAVA_Q_TEST2, JAVA_Q_TEST3));
//        Подготовка 3
        javaQuestionServiceImplRes.remove(JAVA_Q_TEST2);
//        Выполнение 3
        assertEquals(2, javaQuestionServiceImplRes.getAll().size());
        MatcherAssert.assertThat(javaQuestionServiceImplRes.getAll()
                , Matchers.containsInAnyOrder(JAVA_Q_TEST1, JAVA_Q_TEST3));
    }

}

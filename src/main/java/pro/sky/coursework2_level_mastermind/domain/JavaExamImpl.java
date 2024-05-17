package pro.sky.coursework2_level_mastermind.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JavaExamImpl implements JavaExam {

    private static final List<String> javaExamTicketQuestion = new ArrayList<>(Arrays.asList(
            "Определение переменной"
            , "Основные типы переменных"
            , "Количество примитивных типов переменных"
            , "Определение массива"
            , "Определение класса"
            , "Назначение конструктора"
            , "Назначение оператора if"
            , "Назначение оператора for"
            , "Назначение оператора return"
            , "Определение исключения"));

    private static final List<String> javaExamTicketAnswer = new ArrayList<>(Arrays.asList(
            "Основная единица хранения"
            , "Примитивные и ссылочные"
            , "Всего восемь"
            , "Группа однотипных переменных с общем именем"
            , "Логическая конструкция, определяющая форму и сущность объекта"
            , "Инициализация объекта во время его создания"
            , "Это оператор условного ветвления кода"
            , "Это оператор цикла"
            , "Это оператор возврата управления"
            , "Объект, описывающий ошибочную ситуацию"));

    public JavaExamImpl() {
    }

    public String getJavaExamQuestion(int q) {
        return javaExamTicketQuestion.get(q);
    }

    public String getJavaExamAnswer(int a) {
        return javaExamTicketAnswer.get(a);
    }

    public int getJavaExamTicketNum() {
        return javaExamTicketQuestion.size();
    }

    public int getJavaRandomId() {
        return new Random().nextInt(javaExamTicketQuestion.size());
    }

}

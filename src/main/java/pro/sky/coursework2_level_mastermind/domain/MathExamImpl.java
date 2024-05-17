package pro.sky.coursework2_level_mastermind.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MathExamImpl implements MathExam {

    private static final List<String> mathExamTicketQuestion = new ArrayList<>(Arrays.asList(
            "2*2="
            , "3+3="
            , "27/3="
            , "7-4="
            , "5*5="
            , "13-7="
            , "28/4="
            , "24+24="
            , "6*6="
            , "31-13="
    ));

    private static final List<Integer> mathExamTicketAnswer = new ArrayList<>(Arrays.asList(
            4
            , 6
            , 9
            , 3
            , 25
            , 6
            , 7
            , 48
            , 36
            , 18
    ));

    public String getMathExamQuestion(int q) {
        return mathExamTicketQuestion.get(q);
    }

    public int getMathExamAnswer(int a) {
        return (int) mathExamTicketAnswer.get(a);
    }

    public int getMathRandomId() {
        return new Random().nextInt(mathExamTicketQuestion.size());
    }

}

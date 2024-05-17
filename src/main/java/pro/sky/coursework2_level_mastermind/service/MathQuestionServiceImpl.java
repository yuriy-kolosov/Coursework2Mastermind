package pro.sky.coursework2_level_mastermind.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2_level_mastermind.domain.MathExam;
import pro.sky.coursework2_level_mastermind.domain.MathExamImpl;

@Service
public class MathQuestionServiceImpl implements MathQuestionService {

    private int mathExamTicketIdChoice;
    public MathExam mathExam = new MathExamImpl();

    public MathQuestionServiceImpl() {
        this.mathExamTicketIdChoice = 0;
    }

    public MathQuestionServiceImpl(MathExam mathExam) {
        this.mathExamTicketIdChoice = 0;
        this.mathExam = mathExam;
    }

    @Override
    public String genQuestion() {
        mathExamTicketIdChoice = mathExam.getMathRandomId();
        return mathExam.getMathExamQuestion(mathExamTicketIdChoice);
    }

    @Override
    public boolean genAnswer(int a) {
        return mathExam.getMathExamAnswer(mathExamTicketIdChoice) == a;
    }

}

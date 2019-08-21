package training.persistence;

import training.questionnaire.Input;
import training.questionnaire.NumberInput;
import training.questionnaire.Questionnaire;
import training.questionnaire.RadioInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Questionnaire data hardcode loader
 *
 * @version 0.1 21.08.2019
 * @author Oleg
 */
public class HardcodeFactory implements QuestionnaireDAO {

    /**
     * Default constructor
     */
    public HardcodeFactory() {
        super();
    }

    @Override
    public Questionnaire load() {
        List<Input> questions = new ArrayList<>();
        questions.add(new Input(Input.Type.TEXT, "first_name", "First name"));
        questions.add(new Input(Input.Type.TEXT, "last_name", "Last Name"));
        questions.add(new NumberInput(Input.Type.NUMBER, "age", "Age", 18,
                100));
        questions.add(new RadioInput(Input.Type.RADIO, "pet", "Favourite pet",
                "cat", "dog", "pork"));
        questions.add(new RadioInput(Input.Type.RADIO, "beverage",
                "Favourite beverage", "milk", "juice", "beer"));
        questions.add(new RadioInput(Input.Type.RADIO, "hobby", "Hobby",
                "sports", "reading", "beer"));

        return new Questionnaire(questions);
    }
}
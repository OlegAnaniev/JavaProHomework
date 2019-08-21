package training.questionnaire;

import java.util.List;

/**
 * Class representing a questionnaire
 *
 * @version 0.1 21.08.2019
 * @author Oleg
 */
public class Questionnaire {
    private List<Input> questions;

    /**
     * Default constructor
     */
    public Questionnaire() {
        super();
    }

    /**
     * Parameterized constructor
     *
     * @param questions <code>List&lt;Input&gt;</code>
     */
    public Questionnaire(List<Input> questions) {
        super();
        this.questions = questions;
    }

    /**
     * Gets questions
     *
     * @return <code>List&lt;Input&gt;</code>
     */
    public List<Input> getQuestions() {
        return questions;
    }

    /**
     * Sets questions
     *
     * @param questions <code>List&lt;Input&gt;</code>
     */
    public void setQuestions(List<Input> questions) {
        this.questions = questions;
    }

    /**
     * HTML representation of questionnaire
     *
     * @return <code>String</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Input question : questions) {
            builder.append(question);
        }

        return builder.toString();
    }

    /**
     * Adds result to statistics
     *
     * @param name <code>String</code>
     * @param value <code>String</code>
     */
    public void addReply(String name, String value) {
        for (Input question : questions) {
            if (question.getName().equals(name)) {
                question.addReply(value);
            }
        }
    }

    /**
     * Gets statistics
     *
     * @return <code>String</code>
     */
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();

        for (Input input : questions) {
            builder.append(input.getStatistics());
        }

        return builder.toString();
    }
}
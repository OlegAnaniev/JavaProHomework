package training.questionnaire;

/**
 * Class representing a questionnaire HTML number input
 *
 * @version 0.1 21.08.2019
 * @author Oleg
 */
public class NumberInput extends Input {
    private int min;
    private int max;

    /**
     * Default constructor
     */
    public NumberInput() {
        super();
    }

    /**
     * Parameterized constructor
     *
     * @param type <code>Type</code>
     * @param name <code>String</code>
     * @param label <code>String</code>
     * @param min <code>int</code>
     * @param max <code>int</code>
     */
    public NumberInput(Type type, String name, String label, int min,
                       int max) {
        super(type, name, label);
        this.min = min;
        this.max = max;
    }

    /**
     * Gets input minimum value
     *
     * @return code>int</code>
     */
    public int getMin() {
        return min;
    }

    /**
     * Sets input minimum value
     *
     * @param min code>int</code>
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Gets input maximum value
     *
     * @return code>int</code>
     */
    public int getMax() {
        return max;
    }

    /**
     * Sets input maximum value
     *
     * @param max code>int</code>
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * HTML representation of number input
     *
     * @return <code>String</code>
     */
    @Override
    public String toString() {
        return "<p><label>" + this.getLabel() + "</label>"
                + "<input type='" + this.getType().getValue() + "' name='"
                + this.getName() + "' min = '" + min + "' max = '" + max
                + "'></p>";
    }
}
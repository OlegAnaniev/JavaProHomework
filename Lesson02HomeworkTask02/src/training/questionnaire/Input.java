package training.questionnaire;

/**
 * Class representing a questionnaire HTML input
 *
 * @version 0.1 21.08.2019
 * @author Oleg
 */
public class Input {
    public enum Type {
        TEXT("text"), NUMBER("number"), RADIO("radio");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private Type type;
    private String name;
    private String label;

    /**
     * Default constructor
     */
    public Input() {
        super();
    }

    /**
     * Parameterized constructor
     *
     * @param type <code>Type</code>
     * @param name <code>String</code>
     * @param label <code>String</code>
     */
    public Input(Type type, String name, String label) {
        super();
        this.name = name;
        this.label = label;
        this.type = type;
    }

    /**
     * Gets type
     *
     * @return <code>Type</code>
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets type
     *
     * @param type <code>Type</code>
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Gets name
     *
     * @return <code>String</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name
     *
     * @param name <code>String</code>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets label
     *
     * @return <code>String</code>
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets label
     *
     * @param label <code>String</code>
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * HTML representation of input
     *
     * @return <code>String</code>
     */
    @Override
    public String toString() {
        return "<p><label>" + label + "</label>" +
                "<input type='" + type.value +"' name='" + name + "'></p>";
    }

    /**
     * Adds result to statistics
     *
     * @param value <code>String</code>
     */
    public void addReply(String value) {

    }

    /**
     * Gets statistics
     *
     * @return <code>String</code>
     */
    public String getStatistics() {
        return "";
    }
}
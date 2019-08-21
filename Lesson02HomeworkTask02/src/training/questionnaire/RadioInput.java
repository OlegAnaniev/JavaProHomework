package training.questionnaire;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Class representing a questionnaire HTML radio input
 *
 * @version 0.1 21.08.2019
 * @author Oleg
 */
public class RadioInput extends Input {
    private final static String STATISTICS_FORMAT = "%.2f%%";

    private NavigableMap<String, Integer> values;

    /**
     * Default constructor
     */
    public RadioInput() {
        super();
    }

    /**
     * Parameterized constructor
     *
     * @param type <code>Type</code>
     * @param name <code>String</code>
     * @param label <code>String</code>
     * @param values <code>String...</code>
     */
    public RadioInput(Type type, String name, String label, String... values) {
        super(type, name, label);
        this.values = new TreeMap<>();
        for (String value : values) {
            this.values.put(value, 0);
        }
    }

    /**
     * Gets values
     *
     * @return <code>NavigableMap</code>
     */
    public NavigableMap getValues() {
        return values;
    }

    /**
     * Sets values
     *
     * @param values <code>NavigableMap</code>
     */
    public void setValues(NavigableMap values) {
        this.values = values;
    }

    /**
     * HTML representation of radio input
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("<p><label>"
                + this.getLabel() + "</label><br>");

        for (String value : values.navigableKeySet()) {
            builder.append("<label>" + value + "</label>"
                    + "<input type='" + this.getType().getValue() +"' name='"
                    + this.getName() + "' value ='" + value + "'><br>");
        }

        builder.append("</p>");

        return builder.toString();
    }

    @Override
    public void addReply(String value) {
        Integer currentStat = values.get(value);

        if (currentStat == null) {
            throw new IllegalArgumentException(
                    "The value is not on the questionnaire");
        }

        values.put(value, currentStat + 1);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder("<p><span>" + this.getLabel()
                + "</span><br>");
        int total = calculateTotal();
        String totalPercent;

        for (String key : values.navigableKeySet()) {
            totalPercent = total == 0
                    ? String.format("%.2f%%", 0.0)
                    : String.format(STATISTICS_FORMAT,
                        (double) values.get(key) / total * 100);

            builder.append("<span>" + key + ": </span>"
                    + "<span>" + values.get(key) + " "
                    + totalPercent
                    + "</span><br>");
        }

        builder.append("</p>");

        return builder.toString();
    }

    /**
     * Calculates total amount of replies
     *
     * @return
     */
    private int calculateTotal() {
        int total = 0;

        for (String key : values.navigableKeySet()) {
            total += values.get(key);
        }

        return total;
    }
}
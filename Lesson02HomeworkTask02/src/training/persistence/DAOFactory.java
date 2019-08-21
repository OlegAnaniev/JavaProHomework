package training.persistence;

/**
 * Class providing functionality to load questionnaire data
 *
 * @version 0.1 21.08.2019
 * @author Oleg
 */
public class DAOFactory {
    public enum DataSource {
        HARDCODE
    }

    /**
     * Private constructor to make instance creation impossible
     */
    private DAOFactory() {
        super();
    }

    /**
     * Returns requested loader instance
     *
     * @param source <code>DataSource</code>
     * @return <code>QuestionnaireDAO</code>
     */
    public static QuestionnaireDAO getFactory(DataSource source) {
        switch (source) {
            case HARDCODE:
                return new HardcodeFactory();
            default:
                return null;
        }
    }
}
package training;

import training.persistence.DAOFactory;
import training.persistence.QuestionnaireDAO;
import training.questionnaire.Questionnaire;

/**
 * Service class allowing different servlets and jsp pages access the same
 * questionnaire
 *
 * @version 0.1 21.08.2019
 * @author Oleg
 */
public class QuestionnaireService {
    private static Questionnaire questionnaire;

    /**
     * Private constructor to make instance creation impossible
     */
    private QuestionnaireService() {
        super();
    }

    /**
     * Gets questionnaire
     *
     * @return <code>Questionnaire</code>
     */
    public static Questionnaire getQuestionnaire() {
        if (questionnaire == null) {
            initialize();
        }

        return questionnaire;
    }

    /**
     * Sets questionnaire
     *
     * @param questionnaire <code>Questionnaire</code>
     */
    public static void setQuestionnaire(Questionnaire questionnaire) {
        QuestionnaireService.questionnaire = questionnaire;
    }

    /**
     * Initializes questionnaire
     */
    private static void initialize() {
        QuestionnaireDAO dao = DAOFactory.getFactory(
        		DAOFactory.DataSource.HARDCODE);
        questionnaire = dao.load();
    }

    /**
     * Gets questions as HTML
     *
     * @return <code>String</code>
     */
    public static String getQuestions() {
        if (questionnaire == null) {
            initialize();
        }

        return questionnaire.toString();
    }

    /**
     * Adds result to statistics
     *
     * @param name <code>String</code>
     * @param value <code>String</code>
     */
    public static void addReply(String name, String value) {
        questionnaire.addReply(name, value);
    }

    /**
     * Gets statistics
     *
     * @return <code>String</code>
     */
    public static String getStatistics() {
        return questionnaire.getStatistics();
    }
}
package training.persistence;

import training.questionnaire.Questionnaire;

/**
 * Questionnaire data loader interface
 */
public interface QuestionnaireDAO {
    /**
     * Loads questionnaire data
     *
     * @return
     */
    public Questionnaire load();
}
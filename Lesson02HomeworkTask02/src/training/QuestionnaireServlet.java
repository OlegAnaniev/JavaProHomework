package training;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet accepting questionnaire replies and returning statistics
 *
 * @version 0.1 21.08.2019
 * @author Oleg
 */
public class QuestionnaireServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        sendStatistics(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        QuestionnaireService.addReply("pet", req.getParameter("pet"));
        QuestionnaireService.addReply("beverage",
                req.getParameter("beverage"));
        QuestionnaireService.addReply("hobby", req.getParameter("hobby"));

        sendStatistics(resp);
    }

    /**
     * Returns statistics
     *
     * @param resp <code>HttpServletResponse</code>
     * @throws IOException
     */
    private void sendStatistics(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>Questionnaire statistics</title>"
                + "</head><body>" + QuestionnaireService.getStatistics()
                + "</body></html");
    }
}
<%@ page import="training.QuestionnaireService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questionnaire</title>
</head>
<body>
    <form method="post" action="statistics">
        <%! String innerHtml = QuestionnaireService.getQuestions(); %>
        <%= innerHtml %>
        <input type="submit" value="Отправить">
    </form>
</body>
</html>
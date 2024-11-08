<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Boletim do Aluno</title>
    <link rel="stylesheet" href="boletim.css">
</head>
<body>
    <h1>Boletim do Aluno</h1>
    <c:if test="${not empty boletim}">
        <table>
            <thead>
                <tr>
                    <th>Disciplina</th>
                    <th>Média</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="entry" items="${boletim}">
                    <tr>
                        <td>${entry.key}</td>
                        <td>${entry.value}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty boletim}">
        <p>Nenhuma nota encontrada para este aluno.</p>
    </c:if>
    
    <div class="button-container">
        <a href="AlunoController?action=listSimple">Voltar</a>
    	<a href="index.jsp" style="display: inline-block; padding: 8px 16px; background-color: #4CAF50; color: white; text-align: center; text-decoration: none; border-radius: 4px;">Voltar para o Início</a>
    </div>
    
</body>
</html>

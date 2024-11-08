<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista de Alunos</title>
    <link rel="stylesheet" href="listaAlunos.css"> 
</head>
<body>
    <h1>Gerar boletins alunos</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Boletim</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="aluno" items="${alunos}">
                <tr>
                    <td>${aluno.id}</td>
                    <td>${aluno.nome}</td>
                    <td>
                        <a href="NotaController?action=boletim&id=${aluno.id}">Ver boletim</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="index.jsp" style="display: inline-block; padding: 8px 16px; background-color: #4CAF50; color: white; text-align: center; text-decoration: none; border-radius: 4px;">Voltar para o Início</a>
    
</body>
</html>

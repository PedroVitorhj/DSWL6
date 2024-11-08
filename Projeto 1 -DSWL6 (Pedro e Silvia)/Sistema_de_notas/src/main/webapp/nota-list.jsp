<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista de Notas</title>
    <link rel="stylesheet" href="notalist.css"> 
</head>
<body>
    <h1>Lista de Notas dos Alunos</h1>
    <a href="NotaController?action=new&alunoId=${alunoId}">Adicionar Nova Nota</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID Nota</th>
                <th>Aluno</th>
                <th>Disciplina</th>
                <th>Nota</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="nota" items="${notas}">
                <tr>
                    <td>${nota.id}</td>
                    <td>${alunoId}</td>
                    <td>${nota.disciplina}</td>
                    <td>${nota.nota}</td>
                    <td>
                        <a href="NotaController?action=edit&id=${nota.id}&alunoId=${alunoId}">Editar</a> |
                        <a href="NotaController?action=delete&id=${nota.id}&alunoId=${alunoId}&alunonome=${alunoNome}" 
                           onclick="return confirm('Tem certeza que deseja excluir esta nota?');">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="index.jsp" style="display: inline-block; padding: 8px 16px; background-color: #4CAF50; color: white; text-align: center; text-decoration: none; border-radius: 4px;">Voltar para o Início</a>
    <a href="AlunoController?action=list" style="display: inline-block; padding: 8px 16px; background-color: #0000; color: #4CAF50; text-align: center; text-decoration: none; border-radius: 4px;" >Voltar para alunos</a>
</body>
</html>

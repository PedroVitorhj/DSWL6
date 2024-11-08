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
    <h1>Lista de Alunos</h1>
    <a href="AlunoController?action=new">Adicionar Novo Aluno</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Data de Nascimento</th>
                <th>Ações</th>
                <th>Notas</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="aluno" items="${alunos}">
                <tr>
                    <td>${aluno.id}</td>
                    <td>${aluno.nome}</td>
                    <td>${aluno.email}</td>
                    <td>${aluno.dataNascimento}</td>
                    <td>
                        <a href="AlunoController?action=edit&id=${aluno.id}">Editar</a>
                        |
                        <a href="AlunoController?action=delete&id=${aluno.id}"
                           onclick="return confirm('Tem certeza que deseja excluir este aluno?');">Excluir</a>
                    </td>
                    <td>
                        <a href="NotaController?alunoId=${aluno.id}&alunonome=${aluno.nome}">Notas do aluno</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="index.jsp" style="display: inline-block; padding: 8px 16px; background-color: #4CAF50; color: white; text-align: center; text-decoration: none; border-radius: 4px;">Voltar para o Início</a>
    
</body>
</html>

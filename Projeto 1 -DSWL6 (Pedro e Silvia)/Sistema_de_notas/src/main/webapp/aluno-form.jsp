<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${aluno != null ? "Editar Aluno" : "Adicionar Novo Aluno"}</title>
    <link rel="stylesheet" href="formaluno.css"> 
</head>
<body>
    <h1>${aluno != null ? "Editar Aluno" : "Adicionar Novo Aluno"}</h1>
    <form action="AlunoController?action=${aluno != null ? 'update' : 'insert'}" method="post">
        <input type="hidden" name="action" value="${aluno != null ? 'update' : 'insert'}"/>
        
        <c:if test="${aluno != null}">
            <input type="hidden" name="id" value="${aluno.id}"/>
        </c:if>

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${aluno != null ? aluno.nome : ''}" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${aluno != null ? aluno.email : ''}" required><br>

        <label for="dataNascimento">Data de Nascimento:</label>
        <input type="date" id="dataNascimento" name="dataNascimento" 
               value="${aluno != null ? aluno.dataNascimento : ''}" required><br>

        <input type="submit" value="${aluno != null ? 'Atualizar' : 'Adicionar'}">
        
        <a href="AlunoController?action=list">Cancelar</a>

        <c:if test="${aluno != null}">
            <a href="AlunoController?action=delete&id=${aluno.id}" 
               onclick="return confirm('Tem certeza que deseja excluir este aluno?');">Excluir Aluno</a>
        </c:if>
    </form>
    <a href="index.jsp" style="display: inline-block; padding: 8px 16px; background-color: #4CAF50; color: white; text-align: center; text-decoration: none; border-radius: 4px;">Voltar para o Início</a>
   
</body>
</html>

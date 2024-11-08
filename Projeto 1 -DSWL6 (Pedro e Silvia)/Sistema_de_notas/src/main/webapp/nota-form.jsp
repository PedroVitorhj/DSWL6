<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${nota != null ? "Editar Nota" : "Adicionar Nova Nota"}</title>
    <link rel="stylesheet" href="formnota.css">
</head>
<body>
    <h1>${nota != null ? "Editar Nota" : "Adicionar Nova Nota"}</h1>
    <form action="NotaController" method="post">
        <input type="hidden" name="action" value="${nota != null ? 'update' : 'insert'}"/>

        <c:if test="${nota != null}">
            <input type="hidden" name="id" value="${nota.id}"/>
        </c:if>

        <label for="alunoId">Aluno: </label>
        <input type="number" id="alunoId" name="alunoId" value="${nota != null ? nota.alunoId : alunoId}" readonly><br>

        <label for="disciplina">Disciplina:</label>
        <select id="disciplina" name="disciplina" required>
            <option value="Matemática" ${nota != null && nota.disciplina == "Matemática" ? "selected" : ""}>Matemática</option>
            <option value="Português" ${nota != null && nota.disciplina == "Português" ? "selected" : ""}>Português</option>
            <option value="História" ${nota != null && nota.disciplina == "História" ? "selected" : ""}>História</option>
            <option value="Geografia" ${nota != null && nota.disciplina == "Geografia" ? "selected" : ""}>Geografia</option>
            <option value="Ciências" ${nota != null && nota.disciplina == "Ciências" ? "selected" : ""}>Ciências</option>
            <option value="Inglês" ${nota != null && nota.disciplina == "Inglês" ? "selected" : ""}>Inglês</option>
        </select><br>

        <label for="valor">Nota:</label>
        <input type="number" id="valor" name="valor" min="0" max="10" step="0.1" 
               value="${nota != null ? nota.nota : ''}" required><br>

        <input type="submit" value="${nota != null ? 'Atualizar' : 'Adicionar'}">
        <a href="NotaController?alunoId=${alunoId}">Cancelar</a>

        <c:if test="${nota != null}">
            <a href="NotaController?action=delete&id=${nota.id}" 
               onclick="return confirm('Tem certeza que deseja excluir esta nota?');">Excluir Nota</a>
        </c:if>
    </form>
    <a href="index.jsp" style="display: inline-block; padding: 8px 16px; background-color: #4CAF50; color: white; text-align: center; text-decoration: none; border-radius: 4px;">Voltar para o Início</a>
</body>
</html>

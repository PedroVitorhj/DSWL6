<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sistema de Cadastro de Alunos e Notas</title>
    <link rel="stylesheet" href="inicio.css"> 
</head>
<body>
    <h1>Bem-vindo ao Sistema de Cadastro de Alunos e Notas</h1>
    <p>Escolha uma das opções abaixo para gerenciar os dados:</p>
    
    <div class="button-container">
        <a href="AlunoController?action=list">Gerenciar Alunos</a>
        <a href="AlunoController?action=listSimple">Gerar boletins</a>
    </div>
</body>
</html>

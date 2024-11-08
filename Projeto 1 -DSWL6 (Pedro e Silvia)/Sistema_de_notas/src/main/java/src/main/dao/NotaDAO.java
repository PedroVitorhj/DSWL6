package src.main.dao;

import src.main.dto.NotaDTO;
import src.main.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotaDAO {

    public boolean inserirNota(NotaDTO nota) {
        String sql = "INSERT INTO Nota (aluno_id, disciplina, nota) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, nota.getAlunoId());
            stmt.setString(2, nota.getDisciplina());
            stmt.setDouble(3, nota.getNota());
            
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<NotaDTO> listarNotasPorAluno(int alunoId) {
        List<NotaDTO> notas = new ArrayList<>();
        String sql = "SELECT * FROM Nota WHERE aluno_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, alunoId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                NotaDTO nota = new NotaDTO();
                nota.setId(rs.getInt("id"));
                nota.setAlunoId(rs.getInt("aluno_id"));
                nota.setDisciplina(rs.getString("disciplina"));
                nota.setNota(rs.getDouble("nota"));
                
                notas.add(nota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notas;
    }
    
    public Map<String, Double> calcularBoletimPorAluno(int alunoId) {
        List<NotaDTO> notasDoAluno = listarNotasPorAluno(alunoId);
        
        Map<String, List<Double>> notasPorDisciplina = new HashMap<>();

        for (NotaDTO nota : notasDoAluno) {
            notasPorDisciplina
                .computeIfAbsent(nota.getDisciplina(), k -> new ArrayList<>())
                .add(nota.getNota());
        }

        Map<String, Double> boletim = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : notasPorDisciplina.entrySet()) {
            String disciplina = entry.getKey();
            List<Double> notas = entry.getValue();
            double soma = notas.stream().mapToDouble(Double::doubleValue).sum();
            double media = soma / notas.size();
            boletim.put(disciplina, media);
        }

        return boletim; 
    }
    
    public List<NotaDTO> NotaParaEditar(int id) {
        List<NotaDTO> notas = new ArrayList<>();
        String sql = "SELECT * FROM Nota WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                NotaDTO nota = new NotaDTO();
                nota.setId(rs.getInt("id"));
                nota.setAlunoId(rs.getInt("aluno_id"));
                nota.setDisciplina(rs.getString("disciplina"));
                nota.setNota(rs.getDouble("nota"));
                
                notas.add(nota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notas;
    }

    public boolean atualizarNota(NotaDTO nota) {
        String sql = "UPDATE Nota SET disciplina = ?, nota = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nota.getDisciplina());
            stmt.setDouble(2, nota.getNota());
            stmt.setInt(3, nota.getId());
            
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluirNota(int id) {
        String sql = "DELETE FROM Nota WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
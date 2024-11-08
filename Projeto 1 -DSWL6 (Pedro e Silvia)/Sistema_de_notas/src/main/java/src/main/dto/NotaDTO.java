package src.main.dto;

public class NotaDTO {
    private int id;
    private int alunoId;
    private String disciplina;
    private double nota;
    
    public NotaDTO(){}

    public NotaDTO(int id, int alunoId, String disciplina, double nota) {
        this.id = id;
        this.alunoId = alunoId;
        this.disciplina = disciplina;
        this.nota = nota;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "NotaDTO [id=" + id + ", alunoId=" + alunoId + ", disciplina=" + disciplina + ", nota=" + nota + "]";
    }
}
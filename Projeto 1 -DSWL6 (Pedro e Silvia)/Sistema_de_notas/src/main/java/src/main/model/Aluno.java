package src.main.model;


import java.util.Date;

public class Aluno {
    private int id;
    private String nome;
    private String email;
    private Date dataNascimento;

    public Aluno(){}
    		
    public Aluno(int id, String nome, String email, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    @Override
    public String toString() {
        return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email +
               ", dataNascimento=" + dataNascimento + "]";
    }
}
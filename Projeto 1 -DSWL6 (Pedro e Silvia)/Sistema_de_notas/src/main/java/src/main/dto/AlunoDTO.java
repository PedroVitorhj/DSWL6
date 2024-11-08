package src.main.dto;


import java.util.Date;

public class AlunoDTO {
    private int id;
    private String nome;
    private String email;
    private Date dataNascimento;

    public AlunoDTO(){}

    public AlunoDTO(int id, String nome, String email, Date dataNascimento) {
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
        return "AlunoDTO [id=" + id + ", nome=" + nome + ", email=" + email +
               ", dataNascimento=" + dataNascimento + "]";
    }
}
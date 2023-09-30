package br.edu.ufersa.covidplus.domain.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cpf;
    @Column(unique=true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private LocalDate nascimento;
    @Column(nullable = true , unique = true)
    private String crm;

    @Transient
    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultasMedico;

    @Transient
    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultasPaciente;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getNascimento() {
        return this.nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getCrm() {
        return this.crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Consulta> getConsultasMedico() {
        return this.consultasMedico;
    }

    public void setConsultasMedico(List<Consulta> consultasMedico) {
        this.consultasMedico = consultasMedico;
    }

    public List<Consulta> getConsultasPaciente() {
        return this.consultasPaciente;
    }

    public void setConsultasPaciente(List<Consulta> consultasPaciente) {
        this.consultasPaciente = consultasPaciente;
    }

}

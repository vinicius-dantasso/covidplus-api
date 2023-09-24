package br.edu.ufersa.covidplus.api.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateUserDto {
    @NotBlank(message = "email não pode ser vazio")
    @Email(message = "o email deve ser ser válido")
    private String email;
    @Size(min=8,message="A senha deve ter pelo menos 8 caracteres")
	@NotBlank
	private String senha;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotNull
    private String crm;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate nascimento;

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

    public String getCrm() {
        return this.crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

}

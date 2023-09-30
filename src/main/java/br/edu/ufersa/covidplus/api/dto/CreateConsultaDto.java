package br.edu.ufersa.covidplus.api.dto;

import javax.validation.constraints.NotBlank;

public class CreateConsultaDto {
    @NotBlank
    private String horario;
    @NotBlank
    private String local;
    @NotBlank
    private String cpfMedico;

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCpfMedico() {
        return this.cpfMedico;
    }

    public void setCpfMedico(String cpfMedico) {
        this.cpfMedico = cpfMedico;
    }

}

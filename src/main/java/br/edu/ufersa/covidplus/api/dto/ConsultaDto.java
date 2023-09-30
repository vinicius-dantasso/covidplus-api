package br.edu.ufersa.covidplus.api.dto;

import br.edu.ufersa.covidplus.domain.entities.User;

public class ConsultaDto {
    private String horario;
    private String local;
    private User medico;
    private User paciente;

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

    public User getMedico() {
        return this.medico;
    }

    public void setMedico(User medico) {
        this.medico = medico;
    }

    public User getPaciente() {
        return this.paciente;
    }

    public void setPaciente(User paciente) {
        this.paciente = paciente;
    }

}

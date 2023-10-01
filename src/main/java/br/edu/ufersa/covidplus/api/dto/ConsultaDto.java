package br.edu.ufersa.covidplus.api.dto;

import java.time.LocalDateTime;

public class ConsultaDto {
    private long id;
    private LocalDateTime dataHorario;
    private String local;
    private UserDto medico;
    private UserDto paciente;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataHorario() {
        return this.dataHorario;
    }

    public void setDataHorario(LocalDateTime dataHorario) {
        this.dataHorario = dataHorario;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public UserDto getMedico() {
        return this.medico;
    }

    public void setMedico(UserDto medico) {
        this.medico = medico;
    }

    public UserDto getPaciente() {
        return this.paciente;
    }

    public void setPaciente(UserDto paciente) {
        this.paciente = paciente;
    }

}

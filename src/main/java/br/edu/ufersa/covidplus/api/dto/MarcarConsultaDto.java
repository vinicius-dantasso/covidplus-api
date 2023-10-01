package br.edu.ufersa.covidplus.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MarcarConsultaDto {
    @NotNull
    long id;
    @NotBlank
    String cpfPaciente;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getcpfPaciente() {
        return this.cpfPaciente;
    }

    public void setcpfPaciente(String pacienteCpf) {
        this.cpfPaciente = pacienteCpf;
    }

}

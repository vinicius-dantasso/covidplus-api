package br.edu.ufersa.covidplus.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String horario;
    @Column(nullable = false)
    private String local;
    
    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private User medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = true)
    private User paciente;

    @Transient
    private String cpfMedico;

    @Transient
    private String cpfPaciente;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getCpfMedico() {
        return this.cpfMedico;
    }

    public void setCpfMedico(String cpfMedico) {
        this.cpfMedico = cpfMedico;
    }

    public String getCpfPaciente() {
        return this.cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

}

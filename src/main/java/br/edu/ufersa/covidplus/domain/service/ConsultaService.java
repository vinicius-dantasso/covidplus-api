package br.edu.ufersa.covidplus.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.covidplus.domain.entities.Consulta;
import br.edu.ufersa.covidplus.domain.entities.User;
import br.edu.ufersa.covidplus.domain.repository.ConsultaRepository;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository rep;
    @Autowired
    private UserService userService;

    public List<Consulta> getAll(){
        List<Consulta> consultas = rep.findAll();
        return consultas;
    }


    public Consulta createConsulta(Consulta consulta){
        User medico = userService.getByCpf(consulta.getCpfMedico());
        consulta.setMedico(medico);
        rep.save(consulta);
        return consulta;
    }

    public Consulta marcarConsulta(Consulta consulta) {
        Consulta dataConsul = rep.findById(consulta.getId());
        User paciente = userService.getByCpf(consulta.getCpfPaciente());
        dataConsul.setPaciente(paciente);
        rep.save(dataConsul);
        return dataConsul;
    }

    public String deleteConsulta(long id){
        Consulta consulta = rep.findById(id);

        if(consulta != null) {
            consulta.setPaciente(null);
            rep.save(consulta);
            return "ok";
        }
        return "Consulta não encontrada";
    }

    public List<Consulta> getByCpfMedico(String cpfMedico){
        User medico = userService.getByCpf(cpfMedico);
        List<Consulta> consultas = rep.findByMedico(medico);
        return consultas;
    }

    
}

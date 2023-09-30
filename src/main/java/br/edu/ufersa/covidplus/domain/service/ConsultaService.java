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

    public Consulta getByMedico(User medico){
        Consulta consulta = rep.findByMedico(medico);
        return consulta;
    }

    public Consulta createConsulta(Consulta consulta){
        User medico = userService.getByCpf(consulta.getCpfMedico());
        consulta.setMedico(medico);
        rep.save(consulta);
        return consulta;
    }
}

package br.edu.ufersa.covidplus.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.covidplus.domain.entities.Consulta;
import br.edu.ufersa.covidplus.domain.entities.User;


public interface ConsultaRepository extends JpaRepository<Consulta,Long>{
    
    Consulta findByMedico(User medico);
    Consulta findById(long id);

}

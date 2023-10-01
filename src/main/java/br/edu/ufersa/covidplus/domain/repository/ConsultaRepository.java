package br.edu.ufersa.covidplus.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.covidplus.domain.entities.Consulta;
import br.edu.ufersa.covidplus.domain.entities.User;
import java.util.List;



public interface ConsultaRepository extends JpaRepository<Consulta,Long>{
    
    Consulta findById(long id);
    List<Consulta> findByMedico(User medico);
   // List<Consulta> findByCpfPaciente(String cpfPaciente);
}

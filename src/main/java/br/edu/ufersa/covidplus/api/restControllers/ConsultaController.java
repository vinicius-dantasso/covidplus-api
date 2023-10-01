package br.edu.ufersa.covidplus.api.restControllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.covidplus.api.dto.ConsultaDto;
import br.edu.ufersa.covidplus.api.dto.CreateConsultaDto;
import br.edu.ufersa.covidplus.api.dto.MarcarConsultaDto;
import br.edu.ufersa.covidplus.domain.entities.Consulta;
import br.edu.ufersa.covidplus.domain.service.ConsultaService;

@RestController
@RequestMapping("api/consulta")
public class ConsultaController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ConsultaService service;

    @GetMapping
    public List<ConsultaDto> listar(){
        List<ConsultaDto> consultas = new ArrayList<ConsultaDto>();
        for(Consulta consulta : service.getAll()){
            consultas.add(mapper.map(consulta, ConsultaDto.class));
        }
        return consultas;
    }

    @PostMapping
    public ResponseEntity<ConsultaDto> criar(@Valid @RequestBody CreateConsultaDto dto){
        Consulta consulta = service.createConsulta(mapper.map(dto,Consulta.class));
        ConsultaDto criado = mapper.map(consulta,ConsultaDto.class);

        if(criado == null){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(criado,HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<ConsultaDto> marcar(@Valid @RequestBody MarcarConsultaDto dto){
        Consulta consulta = service.marcarConsulta(mapper.map(dto,Consulta.class));
        ConsultaDto marcado = mapper.map(consulta,ConsultaDto.class);

        if(marcado == null)
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(marcado,HttpStatus.CREATED);
    }

    @DeleteMapping("/{consultaId}")
    public ResponseEntity<String> deleter(@PathVariable long consultaId){
        String teste = service.deleteConsulta(consultaId);

        if(teste.equals("ok")){
            return new ResponseEntity<>("deletado",HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{cpfMedico}")
    public List<ConsultaDto> getByCpfMedico(@PathVariable String cpfMedico){
        List<ConsultaDto> consultasDTO = new ArrayList<ConsultaDto>();
      for(Consulta consulta: service.getByCpfMedico(cpfMedico)){
            consultasDTO.add(mapper.map(consulta,ConsultaDto.class));
      }
      return consultasDTO;
    }
}

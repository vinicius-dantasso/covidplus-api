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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.covidplus.domain.entities.User;
import br.edu.ufersa.covidplus.domain.service.UserService;
import br.edu.ufersa.covidplus.api.dto.CreateUserDto;
import br.edu.ufersa.covidplus.api.dto.UserDto;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
	private ModelMapper mapper;
	@Autowired
	private UserService service;

    @GetMapping
	public List<UserDto> listar(){
		List<UserDto> users = new ArrayList<UserDto>();
		for(User user: service.getAll()) {
			users.add(mapper.map(user, UserDto.class));
		}
		return users;
	}

    @GetMapping ("/email/{userEmail}")
	public ResponseEntity<UserDto> buscar(@PathVariable String userEmail){
		UserDto dto = mapper.map(service.getByEmail(userEmail), UserDto.class);
		if(dto != null) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

    @PostMapping
	public ResponseEntity<UserDto> criar(@Valid @RequestBody CreateUserDto dto){
		User user = service.createUser(mapper.map(dto, User.class));
		UserDto criado = mapper.map(user, UserDto.class);
		
		if(criado == null) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>(criado,HttpStatus.CREATED);
		}
	}

    @DeleteMapping("/{userId}")
	public ResponseEntity<String> deletar(@PathVariable String userId){
		String teste = service.deleteUser(userId);
		
		if(teste.equals("ok")) {
			return new ResponseEntity<>(userId,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

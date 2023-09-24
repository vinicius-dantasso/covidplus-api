package br.edu.ufersa.covidplus.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ufersa.covidplus.domain.entities.User;
import br.edu.ufersa.covidplus.domain.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository rep;
    @Autowired
	private PasswordEncoder passwordEncoder;

    public List<User> getAll(){
		List<User> users = rep.findAll();
		return users;
	}

    public User getByEmail(String email){
		User user = rep.findByEmail(email);
		return user;
	}

    public User getByCpf(String cpf){
        User user = rep.findByCpf(cpf);
        return user;
    }

    public User createUser(User user){
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        rep.save(user);
        return user;
    }

    public String deleteUser(String email) {
		User dataUser = rep.findByEmail(email);
		if(dataUser!=null) {
			rep.delete(dataUser);
			return "ok";
		}
		return "User not Found";
	}
}

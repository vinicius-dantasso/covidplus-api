package br.edu.ufersa.covidplus.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.covidplus.domain.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByEmail(String email);
    User findByCpf(String cpf);
}

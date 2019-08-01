package com.github.leonardowiest.wboss.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.leonardowiest.wboss.server.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    public abstract Usuario findByLogin(String login);

}

package com.example.SystemFinalSpring.repository;

import com.example.SystemFinalSpring.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Usuario findByCodigo(long codigo);
}

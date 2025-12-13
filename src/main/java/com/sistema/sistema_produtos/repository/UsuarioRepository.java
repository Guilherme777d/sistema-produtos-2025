package com.sistema.sistema_produtos.repository;

import com.sistema.sistema_produtos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

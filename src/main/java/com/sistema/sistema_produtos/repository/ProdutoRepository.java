package com.sistema.sistema_produtos.repository;

import com.sistema.sistema_produtos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

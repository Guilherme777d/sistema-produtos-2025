package com.sistema.sistema_produtos.repository;

import com.sistema.sistema_produtos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllByOrderByIdAsc();
    List<Produto> findAllByOrderByNomeAsc();
    List<Produto> findAllByOrderByPrecoAsc();
}

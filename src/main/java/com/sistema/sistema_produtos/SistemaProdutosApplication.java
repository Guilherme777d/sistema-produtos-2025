package com.sistema.sistema_produtos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sistema.sistema_produtos.entity.Produto;
import com.sistema.sistema_produtos.repository.ProdutoRepository;

@SpringBootApplication
public class SistemaProdutosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaProdutosApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ProdutoRepository produtoRepository) {
        return args -> {
            Produto p = new Produto("Mouse Gamer", 150.0, 10);
            produtoRepository.save(p);
            System.out.println("✔ Produto salvo com sucesso!");
        };
    }
}

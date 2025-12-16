package com.sistema.sistema_produtos.controller;

import com.sistema.sistema_produtos.entity.Produto;
import com.sistema.sistema_produtos.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoRestController {

    private final ProdutoRepository produtoRepository;

    public ProdutoRestController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return produtoRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}

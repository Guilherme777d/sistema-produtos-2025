package com.sistema.sistema_produtos.controller;

import com.sistema.sistema_produtos.entity.Produto;
import com.sistema.sistema_produtos.repository.ProdutoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // 🔹 LISTAR PRODUTOS COM ORDENAÇÃO
    @GetMapping
    public String listar(
            @RequestParam(defaultValue = "id") String ordem,
            Model model) {

        List<Produto> produtos;

        switch (ordem) {
            case "nome":
                produtos = produtoRepository.findAllByOrderByNomeAsc();
                break;
            case "preco":
                produtos = produtoRepository.findAllByOrderByPrecoAsc();
                break;
            default:
                produtos = produtoRepository.findAllByOrderByIdAsc();
        }

        model.addAttribute("produtos", produtos);
        model.addAttribute("ordem", ordem);
        return "produtos/listar";
    }

    // 🔹 TELA NOVO PRODUTO
    @GetMapping("/novo")
    public String novoProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/novo";
    }

    // 🔹 SALVAR PRODUTO (NOVO ou EDITADO)
    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/produtos?sucesso=salvo";
    }

    // 🔹 TELA EDITAR PRODUTO
    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto inválido: " + id));

        model.addAttribute("produto", produto);
        return "produtos/editar";
    }

    // 🔹 EXCLUIR PRODUTO
    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        return "redirect:/produtos?sucesso=excluido";
    }
}

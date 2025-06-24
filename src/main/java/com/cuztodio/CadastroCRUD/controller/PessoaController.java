package com.cuztodio.CadastroCRUD.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @PostMapping("/criar")
    public String criaPessoa(){
        return "Pessoa cadastrada!";
    }

    @GetMapping("/buscar/{id}")
    public String exibiPessoa(){
        return "Pessoa mostrada!";
    }

    @GetMapping("/buscar/todos")
    public String exibiPessoas(){
        return "Pessoas mostradas";
    }

    @PutMapping("/alterar/{id}")
    public String alterarPessoa(){
        return "Pessoa alterada";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarPessoa(){
        return "Pessoa deletada";
    }
}

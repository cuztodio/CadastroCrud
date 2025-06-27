package com.cuztodio.CadastroCRUD.controller;
import com.cuztodio.CadastroCRUD.model.PessoaModel;
import com.cuztodio.CadastroCRUD.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/criar")
    public String criaPessoa(){
        return "Pessoa cadastrada!";
    }

    @GetMapping("/buscar/{id}")
    public String exibiPessoa(){
        return "Pessoa mostrada!";
    }

    @GetMapping("/buscar/todos")
    public List<PessoaModel> exibiPessoas(){
        return pessoaService.listarTodos();
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

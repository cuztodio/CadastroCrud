package com.cuztodio.CadastroCRUD.controller;
import com.cuztodio.CadastroCRUD.model.PessoaModel;
import com.cuztodio.CadastroCRUD.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/criar")
    public String criaPessoa(@RequestBody PessoaModel pessoaModel){
        pessoaService.criar(pessoaModel);
        return "Pessoa criada!";
    }

    @GetMapping("/buscar/{id}")
    public Optional<PessoaModel> exibiPessoa(@PathVariable Long id){
        return pessoaService.listarPessoa(id);
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

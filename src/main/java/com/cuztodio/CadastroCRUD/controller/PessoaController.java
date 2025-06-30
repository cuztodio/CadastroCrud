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
    public String alterarPessoa(@PathVariable Long id, @RequestBody PessoaModel pessoaModel){
        pessoaService.atualizar(id, pessoaModel);
        return "Pessoa atualizada!";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarPessoa(@PathVariable Long id){
        pessoaService.delete(id);
        return "Pessoa deletada!";
    }
}

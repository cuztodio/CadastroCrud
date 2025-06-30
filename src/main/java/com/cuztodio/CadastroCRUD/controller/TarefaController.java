package com.cuztodio.CadastroCRUD.controller;

import com.cuztodio.CadastroCRUD.model.TarefaModel;
import com.cuztodio.CadastroCRUD.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping("/criar")
    public String criaTarefa(@RequestBody TarefaModel tarefaModel){
        tarefaService.criar(tarefaModel);
        return "Tarefa criada!";
    }

    @GetMapping("/buscar/{id}")
    public Optional<TarefaModel> exibiTarefa(@PathVariable Long id){
        return tarefaService.listarPessoa(id);
    }

    @GetMapping("/buscar/todos")
    public List<TarefaModel> exibiTarefas(){
        return tarefaService.listarTodos();
    }

    @PutMapping("/alterar/{id}")
    public String alterarTarefa(@PathVariable Long id, @RequestBody TarefaModel tarefaModel){
        tarefaService.atualizar(id, tarefaModel);
        return "Tarefa atualizada!";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarTarefa(@PathVariable Long id){
        tarefaService.delete(id);
        return "Tarefa deletada!";
    }
}

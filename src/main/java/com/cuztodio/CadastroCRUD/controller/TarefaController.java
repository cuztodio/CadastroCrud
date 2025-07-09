package com.cuztodio.CadastroCRUD.controller;

import com.cuztodio.CadastroCRUD.dto.TarefaDto;
import com.cuztodio.CadastroCRUD.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping("/criar")
    public String criaTarefa(@RequestBody TarefaDto tarefaDto){
        tarefaService.criarTarefa(tarefaDto);
        return "Tarefa criada!";
    }

    @GetMapping("/buscar/{id}")
    public TarefaDto exibiTarefa(@PathVariable Long id) {
        return tarefaService.listarTarefa(id);
    }

    @GetMapping("/buscar/todos")
    public List<TarefaDto> exibiTarefas() {
        return tarefaService.listarTodos();
    }

    @PutMapping("/alterar/{id}")
    public String alterarTarefa(@PathVariable Long id, @RequestBody TarefaDto tarefaDto){
        tarefaService.atualizar(id, tarefaDto);
        return "Tarefa atualizada!";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarTarefa(@PathVariable Long id){
        tarefaService.delete(id);
        return "Tarefa deletada!";
    }
}

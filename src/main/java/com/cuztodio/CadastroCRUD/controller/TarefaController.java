package com.cuztodio.CadastroCRUD.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @PostMapping("/criar")
    public String criaTarefa(){
        return "Tarefa cadastrada!";
    }

    @GetMapping("/buscar/{id}")
    public String exibiTarefa(){
        return "Tarefa mostrada!";
    }

    @GetMapping("/buscar/todos")
    public String exibiTarefas(){
        return "Tarefas mostradas";
    }

    @PutMapping("/alterar/{id}")
    public String alteraTarefa(){
        return "Tarefa alterada";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarTarefa(){
        return "Tarefa deletada";
    }
}

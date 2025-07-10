package com.cuztodio.CadastroCRUD.controller;

import com.cuztodio.CadastroCRUD.dto.TarefaDto;
import com.cuztodio.CadastroCRUD.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping("/criar")
    public ResponseEntity<String> criaTarefa(@RequestBody TarefaDto tarefaDto){
        tarefaService.criarTarefa(tarefaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tarefa criada com sucesso!");
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TarefaDto> exibiTarefa(@PathVariable Long id) {
        if(tarefaService.listarTarefa(id) != null){
            return ResponseEntity.status(HttpStatus.FOUND).body(tarefaService.listarTarefa(id));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<TarefaDto>> exibiTarefas() {
        return ResponseEntity.ok(tarefaService.listarTodos());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarTarefa(@PathVariable Long id, @RequestBody TarefaDto tarefaDto){

        if(tarefaService.listarTarefa(id) != null){
            tarefaService.atualizar(id, tarefaDto);
            return ResponseEntity.ok().body("Tarefa atualizada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa nao encontrda!");
        }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarTarefa(@PathVariable Long id){

        if(tarefaService.listarTarefa(id) != null){
            tarefaService.delete(id);
            return ResponseEntity.ok().body("Tarefa deletada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa nao encontrada!");
        }
    }
}

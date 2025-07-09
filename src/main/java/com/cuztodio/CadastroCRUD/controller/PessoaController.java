package com.cuztodio.CadastroCRUD.controller;
import com.cuztodio.CadastroCRUD.dto.PessoaDto;
import com.cuztodio.CadastroCRUD.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/criar")
    public ResponseEntity<String> criaPessoa(@RequestBody PessoaDto pessoaDto){
        pessoaService.criar(pessoaDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("A pessoa foi criada com sucesso!");
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PessoaDto> exibiPessoa(@PathVariable Long id){

         if(pessoaService.listarPessoa(id) != null){
             return ResponseEntity.status(HttpStatus.FOUND).body(pessoaService.listarPessoa(id));
         }else{
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<PessoaDto>> exibiPessoas(){
        return ResponseEntity.ok(pessoaService.listarTodos());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarPessoa(@PathVariable Long id, @RequestBody PessoaDto pessoaDto){

        if(pessoaService.listarPessoa(id) != null){
            pessoaService.atualizar(id, pessoaDto);
            return ResponseEntity.ok().body("Pessoa atualizada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa nao encontrada!");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPessoa(@PathVariable Long id){
        if(pessoaService.listarPessoa(id) != null){
            pessoaService.delete(id);
            return ResponseEntity.ok().body("Pessoa deletada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa nao encontrada!");
        }
    }
}

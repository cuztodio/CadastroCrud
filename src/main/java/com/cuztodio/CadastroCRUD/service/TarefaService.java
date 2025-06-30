package com.cuztodio.CadastroCRUD.service;

import com.cuztodio.CadastroCRUD.model.TarefaModel;
import com.cuztodio.CadastroCRUD.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefasRepository tarefasRepository;

    public TarefaModel criar(TarefaModel tarefaModel){
        return tarefasRepository.save(tarefaModel);
    }

    public Optional<TarefaModel> listarPessoa(Long id){
        return tarefasRepository.findById(id);
    }

    public List<TarefaModel> listarTodos(){
        return tarefasRepository.findAll();
    }

    public void delete(Long id){
        tarefasRepository.deleteById(id);
    }

    public TarefaModel atualizar(Long id, TarefaModel tarefaModelnovo){
        if(tarefasRepository.existsById(id)){
            tarefaModelnovo.setId(id);
            return tarefasRepository.save(tarefaModelnovo);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa com ID " + id + " não encontrada");
        }
    }
}

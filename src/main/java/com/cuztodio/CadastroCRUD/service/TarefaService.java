package com.cuztodio.CadastroCRUD.service;

import com.cuztodio.CadastroCRUD.dto.TarefaDto;
import com.cuztodio.CadastroCRUD.mapper.TarefaMapper;
import com.cuztodio.CadastroCRUD.model.TarefaModel;
import com.cuztodio.CadastroCRUD.repository.TarefasRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TarefaService {

    private TarefasRepository tarefasRepository;
    private TarefaMapper tarefaMapper;

    public TarefaDto criarTarefa(TarefaDto tarefaDto){
        TarefaModel tarefaModel = tarefaMapper.map(tarefaDto);
        tarefasRepository.save(tarefaModel);
        return tarefaMapper.map(tarefaModel);
    }

    public TarefaDto listarTarefa(Long id){
        Optional<TarefaModel> tarefaModel = tarefasRepository.findById(id);
        return tarefaModel.map(tarefaMapper::map).orElse(null);
    }

    public List<TarefaDto> listarTodos(){
        List<TarefaModel> tarefaModels = tarefasRepository.findAll();
        return tarefaModels.stream()
                .map(tarefaMapper::map)
                .collect(Collectors.toList());
    }

    public void delete(Long id){
        tarefasRepository.deleteById(id);
    }

    public TarefaDto atualizar(Long id, TarefaDto tarefaDto){

        Optional<TarefaModel> tarefaModel = tarefasRepository.findById(id);
        if(tarefaModel.isPresent()){
            TarefaModel tarefaModelNovo = tarefaMapper.map(tarefaDto);
            tarefasRepository.save(tarefaModelNovo);
            return tarefaMapper.map(tarefaModelNovo);
        }else{
            throw new EntityNotFoundException();
        }
    }
}

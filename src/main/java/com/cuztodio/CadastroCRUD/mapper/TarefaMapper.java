package com.cuztodio.CadastroCRUD.mapper;

import com.cuztodio.CadastroCRUD.dto.TarefaDto;
import com.cuztodio.CadastroCRUD.model.TarefaModel;
import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {

    public TarefaModel map(TarefaDto tarefaDto){
        TarefaModel tarefaModel = new TarefaModel();
        tarefaModel.setId(tarefaDto.getId());
        tarefaModel.setNome(tarefaDto.getNome());
        tarefaModel.setDificuldade(tarefaDto.getDificuldade());
        tarefaModel.setPessoa(tarefaDto.getPessoa());

        return tarefaModel;
    }

    public TarefaDto map(TarefaModel tarefaModel){
        TarefaDto tarefaDto = new TarefaDto();
        tarefaDto.setId(tarefaModel.getId());
        tarefaDto.setNome(tarefaModel.getNome());
        tarefaDto.setDificuldade(tarefaModel.getDificuldade());
        tarefaDto.setPessoa(tarefaModel.getPessoa());

        return tarefaDto;
    }
}

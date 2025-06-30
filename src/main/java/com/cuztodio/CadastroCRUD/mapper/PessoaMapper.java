package com.cuztodio.CadastroCRUD.mapper;

import com.cuztodio.CadastroCRUD.dto.PessoaDto;
import com.cuztodio.CadastroCRUD.model.PessoaModel;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public PessoaModel map(PessoaDto pessoaDto){
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setId(pessoaDto.getId());
        pessoaModel.setEmail(pessoaDto.getEmail());
        pessoaModel.setIdade(pessoaDto.getIdade());
        pessoaModel.setNome(pessoaDto.getNome());
        pessoaModel.setTarefa(pessoaDto.getTarefa());
        pessoaModel.setProfissao(pessoaDto.getProfissao());

        return pessoaModel;
    }

    public PessoaDto map(PessoaModel pessoaModel){
        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setId(pessoaModel.getId());
        pessoaDto.setEmail(pessoaModel.getEmail());
        pessoaDto.setIdade(pessoaModel.getIdade());
        pessoaDto.setNome(pessoaModel.getNome());
        pessoaDto.setTarefa(pessoaModel.getTarefa());
        pessoaDto.setProfissao(pessoaModel.getProfissao());

        return pessoaDto;
    }
}

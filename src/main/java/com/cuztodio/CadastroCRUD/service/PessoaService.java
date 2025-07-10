package com.cuztodio.CadastroCRUD.service;

import com.cuztodio.CadastroCRUD.dto.PessoaDto;
import com.cuztodio.CadastroCRUD.mapper.PessoaMapper;
import com.cuztodio.CadastroCRUD.model.PessoaModel;
import com.cuztodio.CadastroCRUD.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaMapper pessoaMapper;

    public PessoaDto criar(PessoaDto pessoaDto){
        PessoaModel pessoaModel = pessoaMapper.map(pessoaDto);
        pessoaRepository.save(pessoaModel);
        return pessoaMapper.map(pessoaModel);
    }

    public PessoaDto listarPessoa(Long id){
        Optional<PessoaModel> pessoaModel = pessoaRepository.findById(id);
        return pessoaModel.map(pessoaMapper::map).orElseThrow(() -> new IllegalArgumentException("Pessoa nao encontrada!"));
    }

    public List<PessoaDto> listarTodos(){
        List<PessoaModel> pessoaModels = pessoaRepository.findAll();
        return pessoaModels.stream().map(pessoaMapper::map).collect(Collectors.toList());
    }

    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }

    public PessoaDto atualizar(Long id, PessoaDto pessoaDto){

        Optional<PessoaModel> pessoaModel = pessoaRepository.findById(id);
        if(pessoaModel.isPresent()){
            PessoaModel pessoaModelnovo = pessoaMapper.map(pessoaDto);
            pessoaRepository.save(pessoaModelnovo);
            return pessoaMapper.map(pessoaModelnovo);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa com ID " + id + " não encontrada");
        }
    }
}

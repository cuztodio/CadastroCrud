package com.cuztodio.CadastroCRUD.service;

import com.cuztodio.CadastroCRUD.dto.PessoaDto;
import com.cuztodio.CadastroCRUD.mapper.PessoaMapper;
import com.cuztodio.CadastroCRUD.model.PessoaModel;
import com.cuztodio.CadastroCRUD.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaMapper pessoaMapper;

    public PessoaDto criar(PessoaDto pessoaDto){
        PessoaModel pessoaModel = pessoaMapper.map(pessoaDto);
        pessoaRepository.save(pessoaModel);
        return pessoaMapper.map(pessoaModel);
    }

    public Optional<PessoaModel> listarPessoa(Long id){
        return pessoaRepository.findById(id);
    }

    public List<PessoaModel> listarTodos(){
        return pessoaRepository.findAll();
    }

    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }

    public PessoaModel atualizar(Long id, PessoaModel pessoaModelnovo){
        if(pessoaRepository.existsById(id)){
            pessoaModelnovo.setId(id);
            return pessoaRepository.save(pessoaModelnovo);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa com ID " + id + " não encontrada");
        }
    }
}

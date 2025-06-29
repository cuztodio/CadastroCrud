package com.cuztodio.CadastroCRUD.service;

import com.cuztodio.CadastroCRUD.model.PessoaModel;
import com.cuztodio.CadastroCRUD.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaModel criar(PessoaModel pessoaModel){
        return pessoaRepository.save(pessoaModel);
    }

    public Optional<PessoaModel> listarPessoa(Long id){
        return pessoaRepository.findById(id);
    }

    public List<PessoaModel> listarTodos(){
        return pessoaRepository.findAll();
    }
}

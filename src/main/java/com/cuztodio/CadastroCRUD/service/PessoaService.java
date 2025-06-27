package com.cuztodio.CadastroCRUD.service;

import com.cuztodio.CadastroCRUD.model.PessoaModel;
import com.cuztodio.CadastroCRUD.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaModel> listarTodos(){
        return pessoaRepository.findAll();
    }
}

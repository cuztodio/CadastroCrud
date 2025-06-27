package com.cuztodio.CadastroCRUD.repository;

import com.cuztodio.CadastroCRUD.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}

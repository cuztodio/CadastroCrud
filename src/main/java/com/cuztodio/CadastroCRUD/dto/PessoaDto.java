package com.cuztodio.CadastroCRUD.dto;

import com.cuztodio.CadastroCRUD.model.TarefaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private TarefaModel tarefa;
    private String profissao;
}

package com.cuztodio.CadastroCRUD.dto;

import com.cuztodio.CadastroCRUD.enums.Dificuldade;
import com.cuztodio.CadastroCRUD.model.PessoaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDto {

    private Long id;
    private String nome;
    private Dificuldade dificuldade;
    private List<PessoaModel> pessoa;
}

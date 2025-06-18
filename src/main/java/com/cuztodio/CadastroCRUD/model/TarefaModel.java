package com.cuztodio.CadastroCRUD.model;

import com.cuztodio.CadastroCRUD.enums.Dificuldade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_tarefa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Dificuldade dificuldade;

    @OneToMany(mappedBy = "tarefa")
    private List<PessoaModel> pessoa;
}

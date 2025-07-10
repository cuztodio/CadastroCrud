package com.cuztodio.CadastroCRUD.model;

import com.cuztodio.CadastroCRUD.enums.Dificuldade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_tarefa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Dificuldade dificuldade;

    @OneToMany(mappedBy = "tarefa")
    @JsonIgnore
    private List<PessoaModel> pessoa;
}

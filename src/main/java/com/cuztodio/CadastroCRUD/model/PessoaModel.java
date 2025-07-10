package com.cuztodio.CadastroCRUD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_pessoa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "tarefa")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private TarefaModel tarefa;

    @Column(name = "profissao")
    private String profissao;
}

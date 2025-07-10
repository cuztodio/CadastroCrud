package com.cuztodio.CadastroCRUD.controller;

import com.cuztodio.CadastroCRUD.dto.PessoaDto;
import com.cuztodio.CadastroCRUD.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/pessoa/ui")
@RequiredArgsConstructor
public class PessoaControllerUI {

    private final PessoaService pessoaService;

    @GetMapping("/buscar/todos")
    public String exibiPessoas(Model model){
        List<PessoaDto> pessoaDtos = pessoaService.listarTodos();
        model.addAttribute("pessoas", pessoaDtos);
        return "listarPessoas";
    }
}

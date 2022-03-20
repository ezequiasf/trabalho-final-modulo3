package com.dbccompany.receitasapp.controller;


import com.dbccompany.receitasapp.dto.UsuarioDTO;
import com.dbccompany.receitasapp.dto.UsuarioFormado;
import com.dbccompany.receitasapp.enumTemplates.SituacoesUsuario;
import com.dbccompany.receitasapp.exceptions.ObjetoNaoEncontradoException;
import com.dbccompany.receitasapp.service.UsuarioService;
import com.dbccompany.receitasapp.templateObjects.UsuarioTemplate;
import com.dbccompany.receitasapp.utils.EmailUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService serviceUsuario;

    @Autowired
    private EmailUtil email;

    //TODO: Depois retirar variável de teste.
    @Value("${spring.mail.username}")
    private String user;

    @ApiOperation(value = "Retorna uma lista de usuários registrados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Os usuários foram listadas com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção no sistema."),})
    @GetMapping("/listarUsuarios")
    public List<UsuarioFormado> listarTodosUsuarios() {
        return serviceUsuario.listarTodosUsuarios();
    }

    @ApiOperation(value = "Encontra um usuário registrado através do id informado.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "O usuário foi informado com sucesso."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @GetMapping("/{idUsuario}")
    public UsuarioFormado encontrarUsuarioPorId(@PathVariable("idUsuario") Integer idUsuario) throws ObjetoNaoEncontradoException {
        return serviceUsuario.encontrarUsuarioPorId(idUsuario);
    }

    @ApiOperation(value = "Cadastra um usuário no banco de dados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Cadastrou o usuário com sucesso no banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PostMapping("/salvar")
    @Validated
    public UsuarioFormado salvarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioFormado userFormado = serviceUsuario.salvarUsuario(usuarioDTO);
        email.enviarEmailTemplate("ezequias.barros@dbccompany.com.br"
                        , "ezequias.barros@dbccompany.com.br", "Teste",
                        new UsuarioTemplate(usuarioDTO),
                        SituacoesUsuario.CADASTRO);
        return userFormado;
    }

    @ApiOperation(value = "Atualiza um usuário no banco de dados através do id informado.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Atualizou com sucesso o usuário no banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @PutMapping("/atualizar/{idUsuario}")
    @Validated
    public UsuarioFormado atualizarUsuario(@PathVariable("idUsuario") Integer idUsuario,
                                           @Valid @RequestBody UsuarioDTO usuarioAtualizar) throws ObjetoNaoEncontradoException {
        UsuarioFormado userForm =  serviceUsuario.atualizarUsuario(usuarioAtualizar, idUsuario);
        email.enviarEmailTemplate(user,user,"Teste",new UsuarioTemplate(userForm),SituacoesUsuario.ATUALIZAR);
        return userForm;
    }

    @ApiOperation(value = "Deleta um usuário do banco de dados.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Deletou o usuáro com sucesso do banco."),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),})
    @DeleteMapping("/deletar/{idUsuario}")
    public UsuarioFormado deletarUsuario(@PathVariable("idUsuario") Integer idUsuario) throws ObjetoNaoEncontradoException {
        UsuarioFormado userForm = serviceUsuario.deletarUsuario(idUsuario);
        email.enviarEmailTemplate(user,user,"Teste delecao",new UsuarioTemplate(userForm),SituacoesUsuario.EXCLUSAO);
        return userForm;
    }

}

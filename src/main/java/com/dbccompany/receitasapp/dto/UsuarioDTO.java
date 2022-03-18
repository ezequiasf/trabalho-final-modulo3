package com.dbccompany.receitasapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {
    @NotBlank(message = "O usuário deve ser informado.")
    @Size(min = 1, max = 10, message = "O nome de usuário deve ter entre 1 e 10 caracteres.")
    private String nomeUsuario;

    @NotBlank(message = "A senha deve ser informada.")
    @Size(min = 5, max = 10, message = "A senha deve ter entre 5 e 10 caracteres.")
    private String senha;

    @NotNull(message = "A data de nascimento deve ser informada.")
    private LocalDate dataNascimento;

    @Email
    @NotBlank(message = "O email deve ser informado.")
    private String email;
}

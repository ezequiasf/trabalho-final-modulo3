package com.dbccompany.receitasapp.entity;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(includeFieldNames = false)
public class Usuario {
    @ToString.Exclude
    private Integer id;

    @NotBlank(message = "O usuário deve ser informado.")
    @Size(min = 5, max = 10, message = "O nome de usuário deve ter entre 5 e 10 caracteres.")
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

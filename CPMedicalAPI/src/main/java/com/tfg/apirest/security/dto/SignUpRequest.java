package com.tfg.apirest.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@FieldNameConstants
public class SignUpRequest {
    /** Nombre del usuario */
    @NotNull(message = "El campo 'nombre' es obligatorio.")
    @NotBlank(message = "El campo 'nombre' no puede ir vacío.")
    private String nombre;
    /** Primer apellido del usuario */
    @NotNull(message = "El campo 'apellido1' es obligatorio.")
    @NotBlank(message = "El campo 'apellido1' no puede ir vacío.")
    private String apellido1;
    /** Segundo apellido del usuario */
    private String apellido2;
    /** Correo electrónico del usuario */
    @NotNull(message = "El campo 'email' es obligatorio.")
    @NotBlank(message = "El campo 'email' no puede ir vacío.")
    @Email(message = "El formato del campo 'email' es incorrecto.")
    @Size(max=255)
    private String email;
    /** Contrasella del usuario*/
    @NotNull(message = "El campo 'password' es obligatorio.")
    @NotBlank(message = "El campo 'password' no puede ir vacío.")
    @Size( max = 40)
    private String password;
    /** Rol del usuario */
    private String rol;
    /** Nombre del hospital al que se va a asociar */
    @NotNull(message = "El campo 'hospital' es obligatorio.")
    @NotBlank(message = "El campo 'hospital' no puede ir vacío.")
    @Size(max = 100)
    private String hospital;
}

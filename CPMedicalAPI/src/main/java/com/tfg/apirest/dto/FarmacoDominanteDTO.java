package com.tfg.apirest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tfg.apirest.validation.group.Crear;
import com.tfg.apirest.validation.group.Modificar;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class FarmacoDominanteDTO {
    /** Nombre */
    @JsonProperty("nombre")
    @NotBlank(message = "El campo 'nombre' no puede ir vacío.")
    @NotNull(message = "El campo 'nombre' es obligatorio.")
    private String nombre;
    /** Concentración */
    @JsonProperty("concentracion")
    @Valid
    @NotNull(message = "El campo 'concentracion' es obligatorio.")
    ConcentracionDTO concentracion;
    /** Presentación */
    @JsonProperty("presentacion")
    @Valid
    @NotNull(message = "El campo 'presentacion' es obligatorio.")
    ConcentracionDTO presentacion;
    /** Dosis */
    @JsonProperty("dosis")
    @Valid
    @NotNull(message = "El campo 'dosis' es obligatorio.")
    DosisDTO dosis;
}

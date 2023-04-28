package com.coppel.back.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class PaisDTO {

    private Integer id;
    @NotNull
    @NotBlank
    @NotBlank
    private String nombre;
    private List<EstadoDTO> estados;
}

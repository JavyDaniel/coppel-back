package com.coppel.back.dto;

import com.coppel.back.enums.Estatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenunciaDTO {

    private Integer id;
    private String folio;
    @NotNull
    private Integer centro;
    @NotEmpty
    @NotBlank
    @NotNull
    private String detalle;
    private EmpresaDTO empresa;
    private EstadoDTO estado;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    private Estatus estatus;
    private List<ComentarioDTO> comentarios;
}

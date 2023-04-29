package com.coppel.back.services;

import com.coppel.back.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioService
{
    public ComentarioDTO crearComentario(ComentarioDTO comentarioDTO, Integer denunciaId);

    public List<ComentarioDTO> verTodos();

    public void eliminar(Integer id);
}

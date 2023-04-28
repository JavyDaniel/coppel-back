package com.coppel.back.services;

import com.coppel.back.dto.PaisDTO;

import java.util.List;

public interface PaisService {

    public PaisDTO crearPais(PaisDTO paisDTO);

    public List<PaisDTO> verPaises();

    public PaisDTO verPaisId(Integer id);

    public PaisDTO actualizarPais(PaisDTO paisDTO, Integer id);

    public void eliminarPais(Integer id);
}

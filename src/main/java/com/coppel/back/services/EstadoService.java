package com.coppel.back.services;

import com.coppel.back.dto.EstadoDTO;

public interface EstadoService {

    public EstadoDTO crearEstado(EstadoDTO estadoDTO, Integer paisId);

    public EstadoDTO verEstadoId(Integer id);

    public EstadoDTO actualizarEstado(EstadoDTO estadoDTO, Integer id);

    public void eliminarEstado(Integer id);
}

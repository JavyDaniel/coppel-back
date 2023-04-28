package com.coppel.back.services;

import com.coppel.back.dto.DenunciaDTO;
import com.coppel.back.enums.Estatus;

import java.text.ParseException;
import java.util.List;

public interface DenunciaService {

    public DenunciaDTO crearDenuncia(DenunciaDTO denunciaDTO, Integer empresaId, Integer estadoId);

    public List<DenunciaDTO> verDenuncias();

    public DenunciaDTO actualizarEstatus(Estatus estatus, Integer id);

}

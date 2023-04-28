package com.coppel.back.services;

import com.coppel.back.dto.EstadoDTO;
import com.coppel.back.dto.PaisDTO;
import com.coppel.back.models.Estado;
import com.coppel.back.models.Pais;
import com.coppel.back.repositories.EstadoRepository;
import com.coppel.back.repositories.PaisRepository;
import com.coppel.back.utils.MHelpers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EstadoServiceImpl implements EstadoService{

    private final EstadoRepository estadoRepository;
    private final PaisRepository paisRepository;
    @Override
    public EstadoDTO crearEstado(EstadoDTO estadoDTO, Integer paisId) {
        Estado estado = MHelpers.modelMapper().map(estadoDTO, Estado.class);
        Pais pais = paisRepository.findById(paisId).orElseThrow(() -> new RuntimeException("Not found"));
        estado.setPais(pais);
        Estado estadoNuevo = estadoRepository.save(estado);
        return MHelpers.modelMapper().map(estadoNuevo, EstadoDTO.class);
    }

    @Override
    public EstadoDTO verEstadoId(Integer id) {
        Estado estado = estadoRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        return MHelpers.modelMapper().map(estado, EstadoDTO.class);
    }

    @Override
    public EstadoDTO actualizarEstado(EstadoDTO estadoDTO, Integer id) {
        Estado estado = estadoRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        estado.setNombre(estadoDTO.getNombre());
        Estado estadoActualizado = estadoRepository.save(estado);
        return MHelpers.modelMapper().map(estadoActualizado, EstadoDTO.class);
    }

    @Override
    public void eliminarEstado(Integer id) {
        Estado estado = estadoRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
       estadoRepository.delete(estado);
    }
}

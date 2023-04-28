package com.coppel.back.services;

import com.coppel.back.dto.PaisDTO;
import com.coppel.back.models.Empresa;
import com.coppel.back.models.Pais;
import com.coppel.back.repositories.PaisRepository;
import com.coppel.back.utils.MHelpers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService{

    private final PaisRepository paisRepository;
    @Override
    public PaisDTO crearPais(PaisDTO paisDTO) {
        Pais pais = MHelpers.modelMapper().map(paisDTO, Pais.class);
        Pais paisNuevo = paisRepository.save(pais);
        return MHelpers.modelMapper().map(paisNuevo, PaisDTO.class);
    }

    @Override
    public List<PaisDTO> verPaises() {
        List<Pais> paises = paisRepository.findAll();
        return paises.stream().map(pais -> MHelpers.modelMapper().map(pais, PaisDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PaisDTO verPaisId(Integer id) {
        Pais pais = paisRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        return MHelpers.modelMapper().map(pais, PaisDTO.class);
    }

    @Override
    public PaisDTO actualizarPais(PaisDTO paisDTO, Integer id) {
        Pais pais = paisRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        pais.setNombre(paisDTO.getNombre());
        Pais paisActualizado = paisRepository.save(pais);
        return MHelpers.modelMapper().map(paisActualizado, PaisDTO.class);
    }

    @Override
    public void eliminarPais(Integer id) {
        Pais pais = paisRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        paisRepository.delete(pais);
    }
}

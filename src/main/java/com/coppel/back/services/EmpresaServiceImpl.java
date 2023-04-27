package com.coppel.back.services;

import com.coppel.back.dto.EmpresaDTO;
import com.coppel.back.models.Empresa;
import com.coppel.back.repositories.EmpresaRepository;
import com.coppel.back.utils.MHelpers;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Override
    public EmpresaDTO crearEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = MHelpers.modelMapper().map(empresaDTO, Empresa.class);
        Empresa empresaNueva = empresaRepository.save(empresa);
        return MHelpers.modelMapper().map(empresaNueva, EmpresaDTO.class);
    }

    @Override
    public List<EmpresaDTO> verEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        return empresas.stream().map(empresa -> MHelpers.modelMapper().map(empresa, EmpresaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public EmpresaDTO verEmpresaId(Integer id) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        return MHelpers.modelMapper().map(empresa, EmpresaDTO.class);
    }

    @Override
    public EmpresaDTO actualizarEmpresa(EmpresaDTO empresaDTO, Integer id) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        empresa.setNombre(empresaDTO.getNombre());
        Empresa empresaActualizada = empresaRepository.save(empresa);
        return MHelpers.modelMapper().map(empresaActualizada, EmpresaDTO.class);
    }

    @Override
    public void eliminarEmpresa(Integer id) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        empresaRepository.delete(empresa);
    }
}

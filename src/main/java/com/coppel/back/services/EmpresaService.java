package com.coppel.back.services;

import com.coppel.back.dto.EmpresaDTO;

import java.util.List;

public interface EmpresaService {

    public EmpresaDTO crearEmpresa(EmpresaDTO empresaDTO);

    public List<EmpresaDTO> verEmpresas();

    public EmpresaDTO verEmpresaId(Integer id);

    public  EmpresaDTO actualizarEmpresa(EmpresaDTO empresaDTO, Integer id);

    public void eliminarEmpresa(Integer id);
}


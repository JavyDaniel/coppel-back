package com.coppel.back.services;

import com.coppel.back.dto.DenunciaDTO;
import com.coppel.back.enums.Estatus;
import com.coppel.back.models.Denuncia;
import com.coppel.back.models.Empresa;
import com.coppel.back.models.Estado;
import com.coppel.back.repositories.DenunciaRepository;
import com.coppel.back.repositories.EmpresaRepository;
import com.coppel.back.repositories.EstadoRepository;
import com.coppel.back.utils.MHelpers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DenunciaServiceImpl implements DenunciaService {

    private final DenunciaRepository denunciaRepository;
    private final EmpresaRepository empresaRepository;
    private final EstadoRepository estadoRepository;

    @Override
    public DenunciaDTO crearDenuncia(DenunciaDTO denunciaDTO, Integer empresaId, Integer estadoId) {

        Empresa empresa = empresaRepository.findById(empresaId).orElseThrow(() -> new RuntimeException("Not found"));
        Estado estado = estadoRepository.findById(estadoId).orElseThrow(() -> new RuntimeException("Not found"));

        Denuncia denuncia = MHelpers.modelMapper().map(denunciaDTO, Denuncia.class);
        denuncia.setEmpresa(empresa);
        denuncia.setEstado(estado);
        denuncia.setEstatus(Estatus.NUEVA);

        Denuncia denunciaNueva = denunciaRepository.save(denuncia);

        return MHelpers.modelMapper().map(denunciaNueva, DenunciaDTO.class);
    }

    @Override
    public List<DenunciaDTO> verDenuncias() {

        List<Denuncia> denuncias = denunciaRepository.findAll();

        return denuncias.stream().map(denuncia -> MHelpers.modelMapper().map(denuncia, DenunciaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DenunciaDTO actualizarEstatus(Estatus estatus, Integer id) {

        Denuncia denuncia = denunciaRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        denuncia.setEstatus(estatus);
        return MHelpers.modelMapper().map(denuncia, DenunciaDTO.class);
    }


}

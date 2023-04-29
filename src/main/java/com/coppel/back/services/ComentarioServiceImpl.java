package com.coppel.back.services;

import com.coppel.back.dto.ComentarioDTO;
import com.coppel.back.models.Comentario;
import com.coppel.back.models.Denuncia;
import com.coppel.back.repositories.ComentarioRepository;
import com.coppel.back.repositories.DenunciaRepository;
import com.coppel.back.utils.MHelpers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ComentarioServiceImpl implements ComentarioService{

    private final ComentarioRepository comentarioRepository;
    private final DenunciaRepository denunciaRepository;

    @Override
    public ComentarioDTO crearComentario(ComentarioDTO comentarioDTO, Integer denunciaId) {

        Denuncia denuncia = denunciaRepository.findById(denunciaId).orElseThrow(()-> new RuntimeException("Not found"));
        Comentario comentario = MHelpers.modelMapper().map(comentarioDTO, Comentario.class);
        comentario.setDenuncia(denuncia);
        Comentario nuevoComentario = comentarioRepository.save(comentario);

        return MHelpers.modelMapper().map(nuevoComentario, ComentarioDTO.class);
    }

    @Override
    public List<ComentarioDTO> verTodos() {
        List<Comentario> comentarios = comentarioRepository.findAll();
        return  comentarios.stream().map(comentario -> MHelpers.modelMapper().map(comentario, ComentarioDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void eliminar(Integer id) {

        Comentario comentario = comentarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
        comentarioRepository.delete(comentario);

    }
}

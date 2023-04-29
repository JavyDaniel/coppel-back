package com.coppel.back.controllers;

import com.coppel.back.dto.ComentarioDTO;

import com.coppel.back.services.ComentarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comentarios")
@RequiredArgsConstructor
public class ComentarioController {

    private final ComentarioService comentarioService;

    @PostMapping("/crear/{denunciaId}")
    public ResponseEntity<ComentarioDTO> crearComentario(@Valid @RequestBody ComentarioDTO comentarioDTO, @PathVariable(name = "denunciaId") Integer denunciaId) {
        return new ResponseEntity<>(comentarioService.crearComentario(comentarioDTO, denunciaId), HttpStatus.CREATED);
    }

    @GetMapping("/verTodos")
    public List<ComentarioDTO> verComentarios(){return comentarioService.verTodos();
    }

    @DeleteMapping("/eliminar/{comentarioId}")
    public ResponseEntity<String> eliminarPais(@PathVariable(name = "comentarioId") Integer comentarioId) {
        comentarioService.eliminar(comentarioId);
        return ResponseEntity.ok("Comentario eliminado");
    }
}

package com.coppel.back.controllers;

import com.coppel.back.dto.EstadoDTO;
import com.coppel.back.dto.PaisDTO;
import com.coppel.back.services.EstadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estados")
@RequiredArgsConstructor
public class EstadoController {

    private final EstadoService estadoService;

    @PostMapping("/crear/{paisId}")
    public ResponseEntity<EstadoDTO> crearEstado(@Valid @RequestBody EstadoDTO estadoDTO,@PathVariable(name = "paisId") Integer paisId){
        return new ResponseEntity<>(estadoService.crearEstado(estadoDTO, paisId), HttpStatus.CREATED);
    }

    @GetMapping("/verUno/{id}")
    public ResponseEntity<EstadoDTO> verEstadoId(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(estadoService.verEstadoId(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EstadoDTO> actualizarPais(@PathVariable(name = "id") Integer id, @Valid @RequestBody EstadoDTO estadoDTO) {
        return new ResponseEntity<>(estadoService.actualizarEstado(estadoDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPais(@PathVariable Integer id) {
        estadoService.eliminarEstado(id);
        return ResponseEntity.ok("Estado eliminado");
    }

}



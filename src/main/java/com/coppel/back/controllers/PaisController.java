package com.coppel.back.controllers;
import com.coppel.back.dto.PaisDTO;
import com.coppel.back.services.PaisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/paises")
@RequiredArgsConstructor
public class PaisController {

    private final PaisService paisService;

    @PostMapping("/crear")
    public ResponseEntity<PaisDTO> crearPais(@Valid @RequestBody PaisDTO paisDTO){
        return new ResponseEntity<>(paisService.crearPais(paisDTO), HttpStatus.CREATED);
    }

    @GetMapping("/verTodos")
    public List<PaisDTO> verPaises(){
        return paisService.verPaises();
    }

    @GetMapping("/verUno/{id}")
    public ResponseEntity<PaisDTO> verPaisId(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(paisService.verPaisId(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PaisDTO> actualizarPais(@PathVariable(name = "id") Integer id, @Valid @RequestBody PaisDTO paisDTO) {
        return new ResponseEntity<>(paisService.actualizarPais(paisDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPais(@PathVariable Integer id) {
        paisService.eliminarPais(id);
        return ResponseEntity.ok("Pais eliminado");
    }

}

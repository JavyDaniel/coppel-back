package com.coppel.back.controllers;

import com.coppel.back.dto.DenunciaDTO;
import com.coppel.back.enums.Estatus;
import com.coppel.back.services.DenunciaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/denuncias")
@RequiredArgsConstructor
public class DenunciaController {

    private final DenunciaService denunciaService;

    @PostMapping("/crear/{empresaId}/{estadoId}")
    public ResponseEntity<DenunciaDTO> crearDenuncia(@Valid @RequestBody DenunciaDTO denunciaDTO,
                                                    @PathVariable(name = "empresaId") Integer empresaId,
                                                    @PathVariable(name = "estadoId") Integer estadoId) {
        return new ResponseEntity<>(denunciaService.crearDenuncia(denunciaDTO, empresaId, estadoId), HttpStatus.CREATED);
    }

    @GetMapping("/verTodas")
    public List<DenunciaDTO> verDenuncias(){return denunciaService.verDenuncias();
    }

    @PutMapping("/actulizarEstatus/{id}/{estatus}")
    public ResponseEntity<DenunciaDTO> actualizarEstatus(@PathVariable(name = "estatus") Estatus estatus,
                                         @PathVariable(name = "id") Integer id){

        return new ResponseEntity<>(denunciaService.actualizarEstatus(estatus, id), HttpStatus.OK);

    }
}

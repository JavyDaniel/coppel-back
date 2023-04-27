package com.coppel.back.controllers;

import com.coppel.back.dto.EmpresaDTO;
import com.coppel.back.services.EmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping("/crear")
    public ResponseEntity<EmpresaDTO> crearEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO){
        return new ResponseEntity<>(empresaService.crearEmpresa(empresaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/verTodas")
    public List<EmpresaDTO> verEmpresas(){
        return empresaService.verEmpresas();
    }

    @GetMapping("/verUna/{id}")
    public ResponseEntity<EmpresaDTO> verEmpresaId(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(empresaService.verEmpresaId(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpresaDTO> actualizarEmpresa(@PathVariable(name = "id") Integer id, @Valid @RequestBody EmpresaDTO empresaDTO) {
        return new ResponseEntity<>(empresaService.actualizarEmpresa(empresaDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarEmpresa(@PathVariable Integer id) {
        empresaService.eliminarEmpresa(id);
        return ResponseEntity.ok("Empresa eliminada");
    }
}

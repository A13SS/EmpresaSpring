package com.structure.empresaspringboot.controller;

import com.structure.empresaspringboot.model.Empleado;
import com.structure.empresaspringboot.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoRESTController {

    @Autowired
    private EmpleadoService empleadoService;

    //En PostMan usaremos un GET con: localhost:8080/api/empleados
    @GetMapping
    public ResponseEntity<List<Empleado>> listarTodos() {
        List<Empleado> empleados = empleadoService.listarTodos();
        return ResponseEntity.ok(empleados);
    }

    //En PostMan usaremos un GET con: localhost:8080/api/empleados/buscar?campo=dni&valor=32000032G
    @GetMapping("/buscar")
    public ResponseEntity<List<Empleado>> buscarPorCampo(
            @RequestParam String campo,
            @RequestParam String valor) {
        if (campo == null || valor == null || campo.trim().isEmpty() || valor.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<Empleado> resultados = empleadoService.buscarPorCampo(campo, valor);
        return ResponseEntity.ok(resultados);
    }

    //En PostMan usaremos un GET con: localhost:8080/api/empleados/nomina/32000032G
    @GetMapping("/nomina/{dni}")
    public ResponseEntity<Map<String, Object>> obtenerNominaPorDni(@PathVariable String dni) {
        if (dni == null || dni.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Map<String, Object> nomina = empleadoService.obtenerNominaPorDni(dni);
        if (nomina == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nomina);
    }

    //En PostMan usaremos un PUT con: localhost:8080/api/empleados/32000032G y escribiremos en el body con raw, el JSON para editar, ejemplo:
    /*{
        "anyos": 7,
            "categoria": 2,  CAMBIE LA CATEGORIA E 4 A 2 POR EJEMPLO
            "dni": "32000032G",
            "id": 1,
            "nombre": "James Cosling",
            "sexo": "H"
    }*/
    @PutMapping("/{dni}")
    public ResponseEntity<?> editarEmpleado(@RequestBody Empleado empleado) {
        try {
            if (empleado.getDni() == null || empleado.getDni().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("El DNI es obligatorio.");
            }
            if (empleado.getNombre() == null || empleado.getSexo() == '\0' ||
                    empleado.getCategoria() == null || empleado.getAnyos() == null) {
                return ResponseEntity.badRequest().body("Todos los campos son obligatorios.");
            }

            boolean exito = empleadoService.editarEmpleado(empleado);
            if (exito) {
                return ResponseEntity.ok().body("Empleado actualizado correctamente.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Empleado no encontrado para actualizar.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar: " + e.getMessage());
        }
    }
}

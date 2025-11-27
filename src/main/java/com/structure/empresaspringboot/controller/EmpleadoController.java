package com.structure.empresaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.structure.empresaspringboot.model.Empleado;
import com.structure.empresaspringboot.service.EmpleadoService;

import java.util.List;
import java.util.Map;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/front")
    public String handleGet(@RequestParam String opcion,
                            @RequestParam(required = false) String dni,
                            Model model) {
        try {
            switch (opcion) {
                case "listar" -> {
                    model.addAttribute("lista", empleadoService.listarTodos());
                    return "listar";
                }
                case "buscarEmpleado" -> {
                    return "buscarEmpleado";
                }
                case "buscarPorDni" -> {
                    return "buscarPorDni";
                }
                case "editar" -> {
                    if (dni == null || dni.isEmpty()) {
                        model.addAttribute("error", "DNI no proporcionado.");
                        return "error";
                    }
                    List<Empleado> empleados = empleadoService.buscarPorCampo("dni", dni);
                    if (empleados.isEmpty()) {
                        model.addAttribute("error", "Empleado no encontrado.");
                        return "error";
                    }
                    model.addAttribute("empleado", empleados.get(0));
                    return "editarEmpleado";
                }
                default -> throw new IllegalArgumentException("Opción no soportada");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error: " + e.getMessage());
            return "error";
        }
    }

    @PostMapping("/front")
    public String handlePost(@RequestParam String opcion,
                             @RequestParam(required = false) String campo,
                             @RequestParam(required = false) String valor,
                             @RequestParam(required = false) String dni,
                             @RequestParam(required = false) String nombre,
                             @RequestParam(required = false) String sexo,
                             @RequestParam(required = false) String categoria,
                             @RequestParam(required = false) String anyos,
                             Model model) {
        try {
            switch (opcion) {
                case "buscarEmpleado" -> {
                    if (campo == null || valor == null || campo.isEmpty() || valor.isEmpty()) {
                        model.addAttribute("error", "Complete todos los campos.");
                        return "buscarEmpleado";
                    }
                    List<Empleado> resultados = empleadoService.buscarPorCampo(campo, valor);
                    model.addAttribute("resultados", resultados);
                    return "buscarEmpleado";
                }
                case "buscarSalario" -> {
                    if (dni == null || dni.isEmpty()) {
                        model.addAttribute("error", "Ingrese DNI.");
                        return "buscarPorDni";
                    }
                    Map<String, Object> data = empleadoService.obtenerNominaPorDni(dni);
                    if (data != null) {
                        model.addAllAttributes(data);
                    } else {
                        model.addAttribute("error", "Empleado no encontrado.");
                    }
                    return "buscarPorDni";
                }
                case "editar" -> {
                    if (dni == null || nombre == null || sexo == null || categoria == null || anyos == null) {
                        model.addAttribute("error", "Todos los campos son obligatorios.");
                        Empleado emp = new Empleado();
                        emp.setDni(dni);
                        emp.setNombre(nombre);
                        emp.setSexo(sexo != null && !sexo.isEmpty() ? sexo.charAt(0) : 'M');
                        emp.setCategoria(-1);
                        emp.setAnyos(-1);
                        model.addAttribute("empleado", emp);
                        return "editarEmpleado";
                    }

                    Empleado emp = new Empleado();
                    emp.setDni(dni);
                    emp.setNombre(nombre);
                    emp.setSexo(sexo.charAt(0));
                    emp.setCategoria(Integer.parseInt(categoria));
                    emp.setAnyos(Integer.parseInt(anyos));

                    if (empleadoService.editarEmpleado(emp)) {
                        model.addAttribute("mensaje", "Empleado actualizado correctamente.");
                        model.addAttribute("resultados", empleadoService.buscarPorCampo("dni", dni));
                        return "buscarEmpleado";
                    } else {
                        model.addAttribute("error", "No se pudo actualizar el empleado.");
                        model.addAttribute("empleado", emp);
                        return "editarEmpleado";
                    }
                }
                default -> throw new IllegalArgumentException("Opción POST no soportada");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error en la operación: " + e.getMessage());
            return "error";
        }
    }
}

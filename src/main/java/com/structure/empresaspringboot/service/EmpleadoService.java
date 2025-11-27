package com.structure.empresaspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.structure.empresaspringboot.model.Empleado;
import com.structure.empresaspringboot.model.Nomina;
import com.structure.empresaspringboot.repository.EmpleadoRepository;
import com.structure.empresaspringboot.repository.NominaRepository;

import java.time.LocalDate;
import java.util.*;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepo;

    @Autowired
    private NominaRepository nominaRepo;

    public List<Empleado> listarTodos() {
        return empleadoRepo.findAll();
    }

    public List<Empleado> buscarPorCampo(String campo, String valor) {
        if (valor == null || valor.isEmpty()) return List.of();

        return switch (campo.toLowerCase()) {
            case "dni" -> empleadoRepo.findByDni(valor);
            case "nombre" -> empleadoRepo.findByNombreIgnoreCase(valor);
            case "sexo" -> {
                char s = valor.charAt(0);
                yield empleadoRepo.findBySexo(s);
            }
            case "categoria" -> {
                int cat = Integer.parseInt(valor);
                yield empleadoRepo.findByCategoria(cat);
            }
            case "anyos" -> {
                int any = Integer.parseInt(valor);
                yield empleadoRepo.findByAnyos(any);
            }
            default -> throw new IllegalArgumentException("Campo no válido: " + campo);
        };
    }

    @Transactional
    public boolean editarEmpleado(Empleado empleado) {
        List<Empleado> empleadoEdit = empleadoRepo.findByDni(empleado.getDni());
        if (empleadoEdit.isEmpty()) return false;

        Empleado e = empleadoEdit.get(0);
        e.setNombre(empleado.getNombre());
        e.setSexo(empleado.getSexo());
        e.setCategoria(empleado.getCategoria());
        e.setAnyos(empleado.getAnyos());
        empleadoRepo.save(e);

        Nomina nomina = nominaRepo.findByEmpleadoDni(e.getDni())
                .orElse(new Nomina());
        nomina.setEmpleado(e);
        nomina.setSueldo(nomina.sueldo(e));
        nomina.setFechaCalculo(LocalDate.now());
        nominaRepo.save(nomina);

        return true;
    }

    public Map<String, Object> obtenerNominaPorDni(String dni) {
        List<Empleado> empleados = empleadoRepo.findByDni(dni);
        if (empleados.isEmpty()) return null;

        Empleado e = empleados.get(0);
        Optional<Nomina> nominaOpt = nominaRepo.findByEmpleadoDni(dni);

        Map<String, Object> data = new HashMap<>();
        data.put("nombre", e.getNombre());
        data.put("dni", dni);
        data.put("sueldo", nominaOpt.map(Nomina::getSueldo).orElse(0.0));
        data.put("sueldo_calculado", new Nomina().sueldo(e));
        return data;
    }
}

package com.structure.empresaspringboot.strategy;

import com.structure.empresaspringboot.model.Empleado;
import com.structure.empresaspringboot.model.Nomina;

public class SueldoStrategy implements CalculadoraDeSueldos {
    private final Nomina nomina = new Nomina();

    @Override
    public double sueldoBase(Empleado empleado ) {
        return nomina.sueldo(empleado);
    }
}

package com.structure.empresaspringboot.strategy;

import com.structure.empresaspringboot.model.Empleado;

//Con el metodo Strategy encapsulamos algoritmos o comportamientos que pueden variar y los hacemos intercambiables en tiempo de ejecucion.
//En este caso imagina que tenemos que modificar los sueldos y añadir un sueldo bonus, dependeriamos de la interfaz strategy y no directamente de Nomina.
public interface CalculadoraDeSueldos {
    double sueldoBase(Empleado empleado);
}

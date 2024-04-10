/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.ToDoubleFunction;
import java.util.stream.DoubleStream;

/**
 *
 * @author aiman
 */
public class Metodos {
    public static Map<String,Double> crearMap(ArrayList<Precipitacion> precipitaciones){
        Map<String,Double> map = new HashMap();
        for(Precipitacion p : precipitaciones){
            map.put(p.getEstacionMeteorologica(),p.getPrecipitacion());
        }
        return map;
    }
    public static long estacionFecha(LocalDate fecha1, LocalDate fecha2, ArrayList<Precipitacion> precipitaciones){
        long tiempo = precipitaciones.stream()
            .filter(lectura -> lectura.getFecha().compareTo(fecha1) >= 0 && lectura.getFecha().compareTo(fecha2) <= 0)
            .map(Precipitacion::getEstacionMeteorologica)
            .distinct()
            .count();
        return tiempo;
    }
    public static OptionalDouble calcularMediaFecha(LocalDate fecha1, LocalDate fecha2, ArrayList<Precipitacion> precipitaciones){
        return precipitaciones.stream()
            .filter(precipitacion -> precipitacion.getFecha().compareTo(fecha1) >= 0 && precipitacion.getFecha().compareTo(fecha2) <= 0)
            .mapToDouble(p -> p.getPrecipitacion())
            .average(); 
    }
}

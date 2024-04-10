/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author aiman
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Precipitacion> precipitaciones = Json.importarJSON("precipitacionesBadajoz.json");
        Json.mostrarJSON(precipitaciones);
        Map<String,Double> map = Metodos.crearMap(precipitaciones);
        System.out.println(map);
        Json.crearJSON(map);
        //Usando API Stream, muestra por consola el registro que tiene la mayor precipitación.
        Optional<Precipitacion> mayorPrecipitacion = precipitaciones.stream()
                .max(Comparator.comparingDouble(Precipitacion::getPrecipitacion));
        System.out.println("Registro con mayor precipitación: "+mayorPrecipitacion);
        //Usando API Stream, muestra por consola el número de estaciones 
        //meteorológicas que han sido leídas entre el 10 de octubre de 2017 y el 20 de octubre de 2017, ambos días incluidos.
        long tiempo = Metodos.estacionFecha(LocalDate.of(2017, 10, 10), LocalDate.of(2017, 10, 20), precipitaciones);
        System.out.println("La diferencia entre las fechas es: "+tiempo);
        //Usando API Stream, calcula la media de precipitaciones de aquellas 
        //estaciones meteorológicas leídas entre el 10 de octubre de 2017 y el 20 de octubre de 2017, ambos días incluidos.
        System.out.println("La media de precipitaciones entre las fechas: "+Metodos.calcularMediaFecha(LocalDate.of(2017, 10, 10), LocalDate.of(2017, 10, 20), precipitaciones));
    }
}

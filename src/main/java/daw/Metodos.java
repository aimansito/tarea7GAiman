/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
}

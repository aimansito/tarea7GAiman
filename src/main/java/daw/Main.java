/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

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
        
    }
}

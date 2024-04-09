/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author aiman
 */
public class Json {
    public static ArrayList<Precipitacion> importarJSON(String nombre) throws IOException{
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());
        
        
        ArrayList<Precipitacion> precipitacion = mapeador.readValue(new File(nombre),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Precipitacion.class));
        return precipitacion;
    }
    public static void mostrarJSON(ArrayList<Precipitacion> precipitacion){
        precipitacion.forEach(System.out::println);
    }
    //Guarda en un fichero JSON, en la raíz del proyecto, el resultado del map. Pasa el objeto map directamente a la hora de generar el archivo.
    public static void crearJSON(Map<String,Double> map) throws IOException{
        ObjectMapper mapeador = new ObjectMapper();
        
        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());
        
        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File("PrecipitacionesJSON.json"), map);
                
    }
}

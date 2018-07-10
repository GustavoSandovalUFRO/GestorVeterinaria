package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;
import modelo.Persona;

public class ManejoArchivoJson {

    private final static String RUTA = "data/";
    private final static String NOMBRE = "objetos.json";

    public static void almacenarPersonasJson(ArrayList<Persona> personas) {


        Type listType = new TypeToken<List<Persona>>() {}.getType();

        Gson gson = new Gson();
        String json = gson.toJson(personas, listType);
        //System.out.println(json);

        try (FileWriter file = new FileWriter(RUTA+NOMBRE)) {
            file.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static ArrayList<Persona> recuperarPersonasJson() {

        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(RUTA+NOMBRE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Persona> personas = gson.fromJson(br, new TypeToken<List<Persona>>(){}.getType());
//        for (Persona p: personas){
//            System.out.println(p);
//        }

      return personas;
    }
}

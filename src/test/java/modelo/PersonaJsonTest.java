/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import modelo.Persona;

import static org.junit.Assert.*;

import utils.ManejoArchivoJson;

/**
 * @author dci
 */
public class PersonaJsonTest {


    @Test
    public void testPersonaJson() {

        ArrayList<Persona> personas = new ArrayList<>();
        Persona p1 = new Persona();
        p1.setId(1);
        p1.setNombres("Juan");
        p1.setApellidos("Perez");
        p1.setFechaNacimiento("14-5-1992");

        Mascota m1 = new Mascota();
        m1.setNombre("boby");
        m1.setRaza("CANINO");

        Mascota m2 = new Mascota();
        m2.setNombre("Felix");
        m2.setRaza("FELINO");

        p1.agregarMascota(m1);
        p1.agregarMascota(m2);

        Persona p2 = new Persona();
        p2.setId(2);
        p2.setNombres("Maria");
        p2.setApellidos("Lopez");
        p2.setFechaNacimiento("14-5-1990");

        personas.add(p1);
        personas.add(p2);

        ManejoArchivoJson.almacenarPersonasJson(personas);

    }

    @Test
    public void testReconstruirObj() {
        ArrayList<Persona> personas = ManejoArchivoJson.recuperarPersonasJson();

        for (Persona p: personas){
            System.out.println(p);

        }

    }

}

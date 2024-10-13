/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class Persona {

    public static boolean getCedula;

        private int cedula;
    private String nombre;
    private String genero;
    private ArrayList<String> asientosSeleccionados;
   

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getGenero() {
        return genero;
    }
     public void setGenero(String genero) {
         this.genero = genero;
     }
     
    public ArrayList<String> getAsientosSeleccionados() {
        return asientosSeleccionados;
    }


    public Persona(int cedula, String nombre, String genero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.asientosSeleccionados = getAsientosSeleccionados();
    }

    }
    

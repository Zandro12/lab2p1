/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import objetos.Asientos;
import objetos.Persona;

/**
 *
 * @author aleja
 */


public class Cinema {

    private ArrayList<Persona> listaPersonas;
    private ArrayList<String> asientosSeleccionados;
    Asientos asientos = new Asientos();
    String[][] matrizAsientos = asientos.getAsientos();

    public Cinema() {
        listaPersonas = new ArrayList<>();
        asientosSeleccionados = new ArrayList<>();  
        inicializarAsientos();

    }

    public void inicializarAsientos() {
        int fila = 1;
        for (int i = 0; i < matrizAsientos.length; i++) {
            char columna = 'A'; 
            for (int j = 0; j < matrizAsientos[i].length; j++) {
                matrizAsientos[i][j] = fila + "" + columna;
                columna++;
            }
            fila++;
        }
    }

    public void insertarPersona() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cedula de la persona:");
        int cedula = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el nombre de la persona:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el genero de la persona:");
        String genero = sc.nextLine();
        Persona persona = new Persona(cedula, nombre, genero);
        listaPersonas.add(persona);
        System.out.println("Persona insertada exitosamente");
    }

    public Persona buscarPersona(int cedula) {
        for (Persona persona : listaPersonas) {
            if (persona.getCedula() == cedula) {
                return persona;
            }
        }
        return null;
    }
    

    public void mostrarAsientos(String[][] asientos) {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void seleccionarAsiento() {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> asientosSeleccionados = new ArrayList<>();
    
    System.out.println("Ingrese su cedula:");
    int cedula = Integer.parseInt(sc.nextLine());

    boolean personaRegistrada = false;
    for (Persona persona : listaPersonas) {
        if (persona.getCedula() == cedula) {
            personaRegistrada = true;
            break;
        }
    }

    if (!personaRegistrada) {
        System.out.println("La persona no esta registrada. Por favor registrese.");
        return;
    }
    
    
    System.out.println("Precios de los asientos:");
    System.out.println("Fila 1 a 4: 5000 colones cada uno.");
    System.out.println("Fila 5 a 8: 3000 colones cada uno.");

    mostrarAsientos(matrizAsientos);

    System.out.println("Ingrese los asientos que desea (maximo 5), separados por comas, por ejemplo: 4D,4E,4F:");
    String asientosSeleccionadosInput = sc.nextLine().toUpperCase();
    String[] asientosArray = asientosSeleccionadosInput.split(",");

    if (asientosArray.length > 5) {
        System.out.println("No puede seleccionar mas de 5 asientos. Intente de nuevo.");
        return;
    }

    int totalPagar = 0;
    boolean compraExitosa = true;

    for (String asiento : asientosArray) {
        int fila = Integer.parseInt(asiento.substring(0, 1));
        String columna = asiento.substring(1);
        
        if (!personaRegistrada) {
        System.out.println("Esta persona ya realizo una compra y no puede comprar de nuevo.");
        return;
        }
        if (asientosSeleccionados.contains(asiento)) {
            System.out.println("El asiento " + asiento + " ya esta reservado. Seleccione otro asiento.");
            compraExitosa = false;
        } else {
            asientosSeleccionados.add(asiento);

            if (fila >= 1 && fila <= 4) {
                totalPagar += 5000;
            } else if (fila >= 5 && fila <= 8) {
                totalPagar += 3000;
            }

            matrizAsientos[fila - 1][columna.charAt(0) - 'A'] = rojo + "XX" + b;
        }
    }

    if (compraExitosa) {
        System.out.println("Compra realizada con exito.");
        System.out.println("Asientos seleccionados: " + String.join(", ", asientosArray));
        System.out.println("Total a pagar: " + totalPagar + " colones.");
    }
}
    
    public void visualizarInformacionPersona() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cedula de la persona:");
        int cedula = Integer.parseInt(sc.nextLine());
        Persona persona = buscarPersona(cedula);
        if (persona != null) {
            System.out.println("Cedula: " + persona.getCedula());
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Genero: " + persona.getGenero());
            System.out.println("Asientos seleccionados: " + asientosSeleccionados);
        } else {
            System.out.println("No se encontro persona con esa cedula.");
        }
    }

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu principal:");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Ver Asientos");
            System.out.println("3. Seleccionar Asientos");
            System.out.println("4. Informacion de las Personas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> insertarPersona();
                case 2 -> mostrarAsientos(matrizAsientos);
                case 3 -> seleccionarAsiento();
                case 4 -> visualizarInformacionPersona();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }
    
        String b = "\u001B[0m"; //borrar      
        String negro = "\033[30m";
        String rojo = "\033[31m";
        String verde = "\033[32m";
        String amarillo = "\033[33m";
        String azul = "\033[34m";
        String magenta = "\033[35m";
        String celeste = "\033[36m";
        String blanco = "\033[37m";

        String fRojo = "\033[41m";
        String fVerde = "\033[42m";
        String fAmarillo = "\033[43m";
        String fAzul = "\033[44m";
        String fMagenta = "\033[45m";
        String fCeleste = "\033[46m";
        String fGris = "\033[47m";

}

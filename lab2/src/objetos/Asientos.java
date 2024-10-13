/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author aleja
 */
public class Asientos {
        private String[][] asientos;


    public Asientos() {
        asientos = new String[8][9];
    }


    public String[][] getAsientos() {
        return asientos;
    }


    public void setAsientos(String[][] asientos) {
        this.asientos = asientos;
    }


    public String getAsiento(int fila, int columna) {
        return asientos[fila][columna];
    }


    public void setAsiento(int fila, int columna, String valor) {
        this.asientos[fila][columna] = valor;
    }
}

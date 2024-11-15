package model;

import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;

    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controladora 
     */
    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacíos.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }

    
    public String jugadaHumano(int fila, int columna) {
        String mensaje;
        int i = fila - 1;
        int j = columna - 1;

        
        if (i < 0 || i >= 3 || j < 0 || j >= 3) {
            return "Error, las coordenadas están fuera del tablero.";
        }

       
        if (tableroTresEnRaya[i][j].equals(" ")) {
            tableroTresEnRaya[i][j] = "O";
            mensaje = "!El jugador ha realizado su jugada exitosamente¡";
        } else {
            mensaje = "!PROBELMAS¡ No se puede realizar la jugada porque la posicion ya esta ocupada...";
        }

        return mensaje;
    }


 
    public String verificarGanador() {
        
        for (int i = 0; i < 3; i++) {
            // Verificar fila i
            if (tableroTresEnRaya[i][0].equals(tableroTresEnRaya[i][1]) &&
                tableroTresEnRaya[i][1].equals(tableroTresEnRaya[i][2]) &&
                !tableroTresEnRaya[i][0].equals(" ")) {
                return tableroTresEnRaya[i][0];
            }
            // Verificar columna i
            if (tableroTresEnRaya[0][i].equals(tableroTresEnRaya[1][i]) &&
                tableroTresEnRaya[1][i].equals(tableroTresEnRaya[2][i]) &&
                !tableroTresEnRaya[0][i].equals(" ")) {
                return tableroTresEnRaya[0][i];
            }
        }

        // Verificar diagonales
        if (tableroTresEnRaya[0][0].equals(tableroTresEnRaya[1][1]) &&
            tableroTresEnRaya[1][1].equals(tableroTresEnRaya[2][2]) &&
            !tableroTresEnRaya[0][0].equals(" ")) {
            return tableroTresEnRaya[0][0];
        }

        if (tableroTresEnRaya[0][2].equals(tableroTresEnRaya[1][1]) &&
            tableroTresEnRaya[1][1].equals(tableroTresEnRaya[2][0]) &&
            !tableroTresEnRaya[0][2].equals(" ")) {
            return tableroTresEnRaya[0][2];
        }

        // Verificar empate
        if (tableroLleno()) {
            return "!Ha sido un empate, no hay ganador¡";
        }

        return "Ningun jugador ha ganado aun..."; 
    }


    private boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tableroTresEnRaya[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public String imprimirResultado(String entrada){
        String mensaje = "";

        if(entrada == "X"){
            mensaje += "!En esta ocasion ha ganado la maquina, suerte para la proxima¡";
        } else if (entrada == "O"){
            mensaje += "!Felicidades, le has ganado a la maquina, demostraste que la IA no podra reemplazaros (aun)¡";
        } else {
            mensaje += entrada;
        }

        return mensaje;

    }

}


    

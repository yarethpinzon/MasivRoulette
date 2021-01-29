package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.bet;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
public class betController {
	rouletteController rouletteController;
    Vector<Integer> apuestas = new Vector<Integer>(); 
    Vector<Float> cantidades = new Vector<Float>(); 
    Vector<Integer> tipoApuestas = new Vector<Integer>(); 
    float apostado = 0;
    int premio = 0;
    static final int CUADRADOS = 38;
    int numerosRuleta[] = new int[CUADRADOS];
    boolean coloresRuleta[] = new boolean[CUADRADOS];
    rouletteController rula = new rouletteController(numerosRuleta, coloresRuleta);  

    public betController() {
        
    }
    
    public void run(){
        DataInputStream is; 
        DataOutputStream os; 
        DataOutputStream oss;
        int entrada = 0;
        float apuesta = 0;
        int tipoApuesta = 0;
        userController userController;
        userController clon = userController;
        int bola = 0;
        int cont = 0;
        boolean ganador = false;
        int posicion = 0; 
        boolean color; 
        String resColor = "";
        while (true) {
        	 
            clon.clear();
            if (entrada<0) {
                try {
                    entrada = is.readInt();
                    System.out.println("Apuesta: " + entrada);
                    apuestas.add(entrada);
                    tipoApuesta = is.readInt();
                    System.out.println("Números, Rojo/Negro, Par/Impar, Bajos/Altos: " + tipoApuesta);
                    tipoApuestas.add(tipoApuesta);
                    apuesta = is.readFloat();
                    System.out.println("Cantidad apuesta: " + apuesta);
                    cantidades.add(apuesta);
                } catch (IOException e) {
                }
            }
            posicion = rouletteController.spring();
            bola = numerosRuleta[posicion];
            color = coloresRuleta[bola];
            if (entrada<0) {
                try {
                    if (bola <= 0) {
                        os.writeUTF("Players loss" + bola);
                        os.writeBoolean(false);
                        os.writeFloat(cantidades.elementAt(cont));
                    } else {
                        if (apuestas.elementAt(cont) == 1) {
                            int resultado = primeraApuesta(bola);
                            ganador = encontrarGanador(bola, cont);
                            if (ganador) {
                                os.writeUTF("Ha ganado el numero: " + resultado);
                                os.writeBoolean(ganador); 
                                os.writeFloat(cantidades.elementAt(cont));
                            } else {
                                os.writeUTF("Pierde a numero");
                                os.writeBoolean(ganador); 
                                os.writeFloat(cantidades.elementAt(cont));
                            }
                        }
                        if (apuestas.elementAt(cont) == 3) {
                            ganador = terceraApuesta(bola, cont);
                            if (ganador) {
                                os.writeUTF("Gana a par/impar");
                                os.writeBoolean(ganador);
                                os.writeFloat(cantidades.elementAt(cont));
                            } else {
                            }
                        }
                    }
                } catch (IOException e) {
                }
                cont++;
            }
             if (bola > 0) {
                if (coloresRuleta[bola]) {
                    System.out.println("(negro)");
                    resColor = "(negro)";
                } else {
                    System.out.println("(rojo)");
                    resColor = "(rojo)";
                }
            } else {
                System.out.println("(verde)");
                resColor = "(verde)";
            }
            try {
            	if (bola > 0) {
                    os = new DataOutputStream(d.getSocket().getOutputStream());
                    os.writeInt(bola);
                    os.writeUTF(resColor);
                }
            } catch (IOException e) {
            }
            clon.clear();
            
        }
    }
    private int primeraApuesta(int bola) { 
        int resultado = 0;
        for (int numero : tipoApuestas) {
            if (numero == bola) {
                resultado = numero;
            }
        }

        return resultado;
    }
    private boolean segundaApuesta(boolean color, int cont) {
        boolean resultado = false;      
        if (tipoApuestas.elementAt(cont) == 0 && color == false) {
            resultado = true;
        } else if (tipoApuestas.elementAt(cont) == 1 && color == true) {
            resultado = true;
        } 
        return resultado;
    }

    private boolean terceraApuesta(int bola, int cont) {
        boolean resultado = false;
        if (tipoApuestas.elementAt(cont) == 0 && bola % 2 == 0) {
            resultado = true;  
        } else if (tipoApuestas.elementAt(cont) == 1 && bola % 2 != 0) {
            resultado = true;
        }
        return resultado;
    }

    private boolean cuartaApuesta(int bola, int cont) {
        boolean resultado = false;
        if (tipoApuestas.elementAt(cont) == 0 && bola < 18) {
            resultado = true;
        } else if (tipoApuestas.elementAt(cont) == 1 && bola >= 18) {
            resultado = true;
        }
        return resultado;
    }

    private boolean encontrarGanador(int bola, int cont) {
        boolean ganador = false;
        if (tipoApuestas.elementAt(cont) == bola) {
            ganador = true;
        }
        return ganador;
    }

}

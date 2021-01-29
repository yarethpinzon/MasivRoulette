package com.example.demo.controller;

import java.util.Random;

public class rouletteController {
	    static final int CUADRADOS = 38;
	    static final int SALDO_INICIAL = 10000;
	    static final int SALDO_MINIMO = -10000;
	    int [] numerosRuleta;
	    boolean [] coloresRuleta; 
	    public rouletteController(int [] numerosRuleta, boolean [] coloresRuleta){
	        int numero = 0;
	        int posicion = 0;
	        boolean color = false;
	        numerosRuleta[0] = 0;
	        for(posicion = 1; posicion < CUADRADOS; posicion++){
	            numerosRuleta[posicion] = numero;
	            numero++;
	        }
	        color = false;
	        for(posicion = 0; posicion <= 12; posicion++){
	            coloresRuleta[posicion] = color;
	            color = !color;
	        }
	        for(posicion = 12; posicion <= 20; posicion++){
	            coloresRuleta[posicion] = color;
	            color = !color;
	        }
	        for(posicion = 20; posicion <= 29; posicion++){
	            coloresRuleta[posicion] = color;
	            color = !color;
	        }
	        for(posicion = 29; posicion < CUADRADOS; posicion++){
	            coloresRuleta[posicion] = color;
	        }
	    }
	    public int spring (){ 
	        int posicion;
	        Random random = new Random();
	        posicion = random.nextInt(CUADRADOS);
	        return posicion;
	    }
}

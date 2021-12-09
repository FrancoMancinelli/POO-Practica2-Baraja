package mainapp;

import java.util.ArrayList;
import java.util.Scanner;

import models.Baraja;
import models.Carta;

public class mainapp {

public static void main(String[] args) {
		
		double dinero = 50;
		String respMenPri;
		double apuesta = 0;
		double puntuacion = 0;
		
		System.out.println("....................................................");
		System.out.println("                  JUEGO 7 Y MEDIO");
		System.out.println("....................................................");
		
		do {
		System.out.println("\n:::::::::::::::::: MENU PRINCIPAL ::::::::::::::::::");
		System.out.println("  »» Dinero: "+dinero+"\n");

		System.out.println("A »» Nueva Partida");
		System.out.println("B »» Salir");
		System.out.print("\n• »» Respuesta:");
		Scanner sc = new Scanner (System.in);
		respMenPri = sc.next();
		
		switch (respMenPri) {
		
		//Iniciar una partida nueva
		case "a":
		case "A":
			//Si no tengo suficiente dinero...
			if(dinero < 5) {
				System.out.println("\n....................................................");
				System.out.println("ERR0R! >>>>  No cuentas con la cantidad <<<< ERR0R!");
				System.out.println("ERR0R! >>>>     de dinero suficiente    <<<< ERR0R!");
				System.out.println("ERR0R! >>>>   para iniciar una partida  <<<< ERR0R!");
				System.out.println("....................................................\n");
			//Si tengo suficiente dinero...
			} else {
				System.out.print("• »» Apuesta:");
				apuesta = Double.parseDouble(sc.next());
				if (apuesta <= dinero) { //Si tengo esa cantidad de dinero...
					if( apuesta >= 5) { //Y si mi apuesta no es menor a 5...
						
						//Comienza el juego y resta el dinero de la cuenta
						dinero -= apuesta;
						Baraja b1 = new Baraja(40, true);
						System.out.println("\n:::::::::::::::::: PANEL DE JUEGO ::::::::::::::::::\n");
						//Al no haber contrincante solo puedes robar e intentar ganar
						//Por lo tanto el programa robara hasta ganar o perder
						do {
							Carta c = b1.robar();
							System.out.println("  »» Has robado la carta: "+ c.getNombreCarta());
							puntuacion += c.Valor7yMedio();
							System.out.println("  »» Tu puntuación actual es: "+ puntuacion);
							System.out.println("");

						} while (puntuacion < 7.5);
						
						//Si saca 7.5 lo da por ganador y suma a su cuenta el doble de lo apostado
						if(puntuacion == 7.5) {
							puntuacion = 0;
							dinero += apuesta * 2;
							System.out.println("\n....................................................");
							System.out.println("$$$$$$ >>>>   ¡Felicidades has ganado!   <<<< $$$$$$");
							System.out.println("WINNER >>>>   Has duplicado tu apuesta   <<<< WINNER");
							System.out.println("$$$$$$ >>>>     Has ganado: "+apuesta*2+"       <<<< $$$$$$");
							System.out.println("....................................................\n");
						//Si saca más de 7.5 lo da por perdido
						} else if (puntuacion > 7.5) {
							puntuacion = 0;
							System.out.println("\n....................................................");
							System.out.println("###### >>>>      ¡Ohh... has perdido!    <<<< ######");
							System.out.println("LOSER  >>>>      Pero no te desanimes    <<<<  LOSER");
							System.out.println("###### >>>>      Vuelve a intentarlo     <<<< ######");
							System.out.println("....................................................\n");
						}
						
						
			 } else { //Error por no haber apostado al menos 5$
				System.out.println("\n....................................................");
				System.out.println("ERR0R! >>>>     Debes apostar al menos   <<<< ERR0R!");
				System.out.println("ERR0R! >>>>      5$ para poder jugar     <<<< ERR0R!");
				System.out.println("ERR0R! >>>>      Vuelve a intentarlo     <<<< ERR0R!");
				System.out.println("....................................................\n");
			}
		} else { //Error por haber apostado más dinero del que tienes
			System.out.println("\n....................................................");
			System.out.println("ERR0R! >>>>  No cuentas con esa cantidad <<<< ERR0R!");
			System.out.println("ERR0R! >>>>    de dinero en tu cuenta.   <<<< ERR0R!");
			System.out.println("ERR0R! >>>>      Vuelve a intentarlo     <<<< ERR0R!");
			System.out.println("....................................................\n");
		}
			}
			break;
			
		//Salir del programa
		case "b":
		case "B":
			System.out.println("\n....................................................");
			System.out.println("\n  »» ¡Hasta pronto!");
			break;
		
		//En caso que la respuesta no este dentro de las opciones...
		default: 
			System.out.println("\n....................................................");
			System.out.println("ERR0R! >>>>   Su respuesta no coincide   <<<< ERR0R!");
			System.out.println("ERR0R! >>>> con alguna opcion disponible <<<< ERR0R!");
			System.out.println("ERR0R! >>>>      Vuelve a intentarlo     <<<< ERR0R!");
			System.out.println("....................................................");

		}
		
		} while (!respMenPri.equals("b") && !respMenPri.equals("B"));
		
		
			
	} //CIERRE MAIN
}

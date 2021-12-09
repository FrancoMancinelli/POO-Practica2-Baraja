package models;

import java.util.ArrayList;
import models.Carta;

public class Baraja {

	//Propiedades o Atributos
	private ArrayList<Carta> listaCartas;
	
	
	//Getters y Setters
	public ArrayList<Carta> getLista() {
		return this.listaCartas;
	}
	
	
	//Constructores
	public Baraja() {
		super();
		this.listaCartas = new ArrayList<Carta>();
	}
	
	public Baraja(int tipobaraja) {
		super();
		if (tipobaraja == 40 || tipobaraja == 80) {
			this.listaCartas = new ArrayList<Carta>();
			for (int id = 1; id <= tipobaraja; id++) {
				try {
					this.listaCartas.add(new Carta(id));
				} catch (Exception e) {
					System.out.println(e);
				}	
				}
		} else {
			System.out.println("La cantidad de cartas debe ser de 40 u 80");
		}
	}
	
	
	public Baraja(int tipobaraja, boolean barajar) {
		super();
		if (tipobaraja == 40 || tipobaraja == 80) {
			this.listaCartas = new ArrayList<Carta>();
			for (int id = 1; id <= tipobaraja; id++) {
				try {
					this.listaCartas.add(new Carta(id));
				} catch (Exception e) {
					System.out.println(e);
				}	
				}
		} else {
			System.out.println("La cantidad de cartas debe ser de 40 u 80");
		}
		if (barajar == true) {
			ArrayList<Carta> listaCartasBarajadas = new ArrayList<Carta>();
			
			do {
				int posicion = (int)(Math.random()*this.listaCartas.size());
				listaCartasBarajadas.add(this.listaCartas.get(posicion));
				this.listaCartas.remove(posicion);
			} while (this.listaCartas.isEmpty() == false);
			
			this.listaCartas = (ArrayList<Carta>) listaCartasBarajadas.clone();
		}
	}

	
	//M�todos
	
	/**
	 * Mezcla las cartas de un array
	 */
	public void barajar() {
		ArrayList<Carta> listaCartasBarajadas = new ArrayList<Carta>();
			
		do {
			int posicion = (int)(Math.random()*this.listaCartas.size());
			listaCartasBarajadas.add(this.listaCartas.get(posicion));
			this.listaCartas.remove(posicion);
		} while (this.listaCartas.isEmpty() == false);
		
		this.listaCartas = (ArrayList<Carta>) listaCartasBarajadas.clone();
		
	}
	
	/**
	 * Quita tantas cartas seg�n se indica y las lleva al final de la baraja
	 * @param posicion En que posicion se debe cortar la baraja
	 */
	public void cortar(int posicion) {
		ArrayList<Carta> listaCartasCortadas = new ArrayList<Carta>();
		for(int i = 0; i < posicion; i++) {
			listaCartasCortadas.add(this.listaCartas.get(0));
			this.listaCartas.remove(0);
			this.listaCartas.add(listaCartasCortadas.get(i));
		}
	}

	/**
	 * Roba la primer carta de la baraja
	 * @return La carta robada
	 */
	public Carta robar() {
		Carta c = this.listaCartas.get(0);
		this.listaCartas.remove(0);
		return c;
	}
	
	/**
	 * Inserta una carta nueva al final de la baraja
	 * @param id_carta El id de la carta a agregar
	 */
	public void InsertarCartaFinal(int id_carta) {
		Carta c = null;
		try {
			c = new Carta (id_carta);
		} catch (Exception e) {
			System.out.println(e);
		}
		this.listaCartas.add(c);
	}
	
	/**
	 * Inserta una carta nueva al principio de la baraja
	 * @param id_carta El id de la carta a agregar
	 */
	public void InsertarCartaPrincipio(int id_carta) {
		Carta c = null;
		try {
			c = new Carta (id_carta);
		} catch (Exception e) {
			System.out.println(e);
		}
		ArrayList<Carta> listaCartasAux = new ArrayList<Carta>();
		listaCartasAux.add(c);
		for(int i = 0; i < this.listaCartas.size(); i++) {
			listaCartasAux.add(this.listaCartas.get(i));
		}
		this.listaCartas.clear();
		this.listaCartas = (ArrayList<Carta>) listaCartasAux.clone();
	}
	
	/**
	 * Inserta una carta nueva al final de la baraja
	 * @param c La carta (objeto) a agregar
	 */
	public void InsertarCartaFinal(Carta c) {
		this.listaCartas.add(c);
	}
	
	/**
	 * Inserta una carta nueva al principio de la baraja
	 * @param c La carta (objeto) a agregar
	 */
	public void InsertarCartaPrincipio(Carta c) {
		ArrayList<Carta> listaCartasAux = new ArrayList<Carta>();
		listaCartasAux.add(c);
		for(int i = 0; i < this.listaCartas.size(); i++) {
			listaCartasAux.add(this.listaCartas.get(i));
		}
		this.listaCartas.clear();
		this.listaCartas = (ArrayList<Carta>) listaCartasAux.clone();
	}
	
	/**
	 * Nos dice la cantidad de cartas que quedan en nuestra baraja
	 */
	public void getNumeroCartas() {
		int cantidad = this.listaCartas.size();
		System.out.println(cantidad);
	}
	
	/**
	 * Verifica si mi baraja a�n tiene cartas
	 * @return false en caso que si este vacia
	 * @return true en caso que noeste vacia
	 */
	public boolean isVacia() {
		if(this.listaCartas.isEmpty() == false) {
			return false;
		} else {
			return true;
		}
	}
	
	
	
	
	
	
	
	
}

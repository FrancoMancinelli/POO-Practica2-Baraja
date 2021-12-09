package models;

public class Carta {

	//Propiedaes o Atributos
	private int numero;
	private int palo;
	
	
	//Constructores
	public Carta(int numero, int palo) {
		super();
		this.numero = numero;
		this.palo = palo;
	
		
	}
	
	public Carta(int id) throws Exception {
		super();
		int n = 1;
		boolean get = false;
		
		if (id > 0 && id <= 80) {
			if(id >= 41 && id <= 80) {
				id = id - 40;
			}
			do {
				if(id % 10 == 0) {
					n = 10;
					get = true;
				} else  if (id % 10 == n) {
					get = true;
				} else {
					n++;
				}
			}while (get == false);
		} else {
			throw new Exception("El ID no corresponde a una carta (1-80)");
		}
		this.numero = n;
	
		int k = 0;
		int m = 0;
		int pal = 0;
		boolean get2 = false;
		
		if (id > 0 && id <= 80) {
			if(id >= 41 && id <= 80) {
				id = id - 40;
			}
			if(id % 10 == 0) {
				m = 1;
			}
				do {
					if(id / 10 == k) {
						pal = k-m;
						get2 = true;
					} else {
						k++;
					}
				}while (get2 == false);
		} else {
			throw new Exception("El ID no corresponde a una carta (1-80)");
		}
		this.palo = pal;
	}

	
	//M�todos
	
	/**
	 * Devuelve el ID correspondiente a la carta
	 * @param numero N�mero de la carta a la cual obtener el id
	 * @param palo Palo de la carta a la cual obtener el id 
	 * @return El ID de esa carta
	 * @throws Exception En caso que el n�mero o el palo no sean correspondientes a una carta
	 */
	public int getID(int numero, int palo) throws Exception {
		if((numero > 0 && numero <= 10) && (palo >= 0 && palo <= 3)) {
		 int id = 0;
		 id = palo * 10 + numero;
		 return id;
		} else {
			throw new Exception("El n�mero o el palo no corresponden a una carta existente");
		}
	}
	
	/**
	 * Devuelve cual es el numero de la carta
	 * @return El n�mero de esa carta
	 */
	public int getNumero() {
		return this.numero;
	}
	
	
	/**
	 * Devuelve el n�mero del palo de la carta
	 * @return El palo de esa carta
	 */
	public int getPalo() throws Exception {
		return this.palo;
	}
	
	
	/**
	 * Devuelve el nombre de la carta seg�n su n�mero (1=As, 2=Dos, 8=Sota, 9=Caballo, 10=Rey)
	 * @param num El n�mero de la carta que se busca obtener el nombre
	 * @return El nombre correspondiente a ese n�mero
	 */
	public String getNombreNumero() { 
		int num = this.numero;
		String nom = "";
		
		if(num > 0 && num <= 10) {
			switch(num) {
			
			case 1:
				nom = "As";
				break;
			case 2:
				nom = "Dos";
				break;
			case 3:
				nom = "Tres";
				break;
			case 4:
				nom = "Cuatro";
				break;
			case 5:
				nom = "Cinco";
				break;
			case 6:
				nom = "Seis";
				break;
			case 7:
				nom = "Siete";
				break;
			case 8:
				nom = "Sota";
				break;
			case 9:
				nom = "Caballo";
				break;
			case 10:
				nom = "Rey";
				break;
			}
			
		}
		return nom;
	}
	
	/**
	 * Devuelve el nombre de la carta seg�n su palo.
	 * @param palo El n�mero del palo (0=Oros, 1=Espadas, 2=Copas, 3=Bastos)
	 * @return El nombre correspondiente a ese palo
	 */
	public String getNombrePalo() {
		int palo = this.palo;
		String nom = "";
		
		if(palo >= 0 && palo <= 3) {
			switch (palo) {
			case 0:
				nom = "Oros";
				break;
			case 1:
				nom = "Espadas";
				break;
			case 2:
				nom = "Copas";
				break;
			case 3:
				nom = "Bastos";
				break;
			}
		}
		return nom;
	}
	
	
	/**
	 * Devuelve el nombre completo de la carta (Ej: Caballo de Copas)
	 * @return El nombre completo de la carta
	 */
	public String getNombreCarta() {
		String nom;
		nom = getNombreNumero() + " de " + getNombrePalo();
		return nom;
	}
	
	
	/**
	 * Devuelve el valor de la carta en el juego del tute
	 * @return El valor de la carta en el juego del tute
	 */
	public int ValorTute () {
		int num = 0;
		try {
			num = getNumero();
		} catch (Exception e) {
			System.out.println(e);
		}
		int valor = 0;
		if (num == 1) {
			valor = 11;
		}
		if (num == 3) {
			valor = 10;
		}
		if (num == 10) {
			valor = 4;
		}
		if (num == 9) {
			valor = 3;
		}
		if (num == 8) {
			valor = 2;
		}
		return valor;
	}
	
	
	/**
	 * Deuvelve el valor de la carta en el juego mus
	 * @return El valor de la carta en el juego mus
	 */
	public int ValorMus () {
		int num = 0;
		try {
			num = getNumero();
		} catch (Exception e) {
			System.out.println(e);
		}
		int valor = 0;
		if (num == 1 || num == 2) {
			valor = 1;
		} else if (num == 3 || num == 8 || num == 9 || num == 10) {
			valor = 10;
		} else {
			valor = num;
		}
	

		return valor;
	}
	
	
	/**
	 * Devuelve el valor de la carta en el juego 7 y medio
	 * @return El valor de la carta en el juego 7 y medio
	 */
	public double Valor7yMedio () {
		int num = 0;
		double valor = 0;
		
		try {
			num = getNumero();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if (num == 8 || num == 9 || num == 10) {
			valor = 0.5;
		} else {
			valor = num;
		}
		
		return valor;
	}

	@Override
	public String toString() {
		return "Carta [numero=" + numero + ", palo=" + palo + "]\n";
		
	}
	
	
}

package alberolf;

import java.util.LinkedList;

public class NodoLf <T> {

	private NodoLf<T> padre;
	private LinkedList<NodoLf<T>> figli;
	private T elemento;

	// Costruttori

	public NodoLf(T elemento, NodoLf<T> padre) {
		this.elemento = elemento;
		this.padre = padre;
		this.figli = new LinkedList<NodoLf<T>>();
	}

	public NodoLf(T elemento) {
		this(elemento, null);
	}


	// Metodi get e set 
	 
	public NodoLf<T> getPadre() {   //restituire il padre di un nodo
		return padre;
	}

	public void setPadre(NodoLf<T> padre) {
		this.padre = padre;
	}

	public LinkedList<NodoLf<T>> getFigli() {
		return figli;
	}

	public T getElemento() {    //restituire l’informazione di un nodo
		return elemento;
	}

	public void setElemento(T elemento) {   //cambiare l’informazione di un nodo
		this.elemento = elemento;
	}
		
	// Metodi
	
	public int getLivello() {   //restituire il livello di un nodo
		int livello = 0;
		NodoLf<T> padre = this.getPadre();
		while (padre != null) {
			livello++;
			padre = padre.getPadre();
		}

		return livello;
	}
	
	public boolean isFoglia() {
		return figli.isEmpty();
	}
	
	public String toString(){
		return elemento.toString();
	}

	public void addFiglio(NodoLf<T> temp) {
		figli.add(temp);	
	}
	
}

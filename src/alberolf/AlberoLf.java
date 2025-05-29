package alberolf;

import java.util.LinkedList;

import java.util.Stack;

/**
 * 
 * @author Serena Vannacci 7030223
 * 
 * @param <T>
 * 
 */

public class AlberoLf<T> {

	private NodoLf<T> radice;
	private int nNodi;
	private int altezza;

	// Costruttori

	private AlberoLf(NodoLf<T> radice, int nNodi, int altezza) {
		this.radice = radice;
		this.nNodi = nNodi;
		this.altezza = altezza;
	}

	public AlberoLf() {
		this(null, 0, 0);
	}

	public AlberoLf(T radice) { // inserire la radice dell’albero specificando la sola informazione
		this(new NodoLf<T>(radice), 1, 1);
	}

	// Metodi set e get

	public NodoLf<T> getRadice() { // restituire la radice dell’albero
		return radice;
	}

	public NodoLf<T> setRadice(T elemento) { // inserire la radice dell’albero
		if (radice != null) { // specificando la sola informazione
			return null;
		}
		radice = new NodoLf<T>(elemento);
		nNodi++;
		altezza++;

		return radice;
	}

	public int getnNodi() { // restituire il numero dei nodi presenti nell’albero
		return nNodi;
	}

	public int getAltezza() { // restituire l’altezza dell’albero
		return altezza;
	}

	// Metodi

	public NodoLf<T> nuovaRadice(T elemento) { // inserire una nuova radice nell’albero
		NodoLf<T> temp = new NodoLf<T>(elemento); // in maniera che la vecchia radice
		radice.setPadre(temp); // diventi figlia di quella nuova
		temp.addFiglio(radice);
		nNodi++;
		altezza++;
		return radice = temp;

	}

	public NodoLf<T> aggiungiNodo(NodoLf<T> padre, T elemento) { // inserire un nodo nell’albero specificando padre e
																	// informazione
		NodoLf<T> temp = new NodoLf<T>(elemento, padre);

		padre.addFiglio(temp);
		if (temp.getLivello() >= altezza) {
			altezza++;
		}
		nNodi++;
		return temp;
	}

	public int getNumeroFoglie() { // Numero foglie
		return contaFoglie(radice, 0);
	}

	private int contaFoglie(NodoLf<T> nodo, int conteggio) {
		if (nodo.isFoglia()) {
			return conteggio + 1;
		}

		for (NodoLf<T> figlio : nodo.getFigli()) {
			conteggio = contaFoglie(figlio, conteggio);
		}

		return conteggio;

	}

//  metodi che restituisce una stringa che sia la rappresentazione dell’albero

	public String toString() { 
		String stringa = "";
		return stringa = toStringNodi(radice, stringa);

	}

	private String toStringNodi(NodoLf<T> nodo, String stringa) {
		
		boolean primo = true;
		if (nodo.getElemento() == null) { // Nel caso ci fosse un nodo con elemento null
			stringa += "null";
		} else {
			stringa += nodo.getElemento().toString();
		}

		stringa += "[";

		for (NodoLf<T> figlio : nodo.getFigli()) {
			// Posizionamento corretto della virgola
			if (primo) {
				stringa = toStringNodi(figlio, stringa);
				primo = false;
			} else {
				stringa += ",";
				stringa = toStringNodi(figlio, stringa);
			}
		}

		stringa += "]";

		return stringa;
	}

	// metodo che restituisce la lista delle informazioni dei nodi dell’albero visitato in profondità


	public LinkedList<T> visitaProfondita() {
		Stack<NodoLf<T>> stack = new Stack<NodoLf<T>>();
		LinkedList<T> elementi = new LinkedList<T>();

		stack.push(radice);
		while (!stack.isEmpty()) {
			NodoLf<T> nodo = stack.pop();
			elementi.add(nodo.getElemento());

			for (int i = nodo.getFigli().size(); i > 0; i--) {
				NodoLf<T> figlio = nodo.getFigli().get(i - 1);
				stack.push(figlio);

			}
		}

		return elementi;
	}

	// metodo che restituisce la lista delle informazioni dei nodi dell’albero visitato in ampiezza

	public LinkedList<T> visitaAmpiezza() {
		LinkedList<NodoLf<T>> stack = new LinkedList<NodoLf<T>>();
		LinkedList<T> elementi = new LinkedList<T>();

		stack.push(radice);
		while (!stack.isEmpty()) {
			NodoLf<T> nodo = stack.remove();
			elementi.add(nodo.getElemento());

			for (NodoLf<T> figlio : nodo.getFigli()) {
				stack.add(figlio);

			}
		}

		return elementi;
	}

}

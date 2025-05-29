package alberolf;
	
import java.util.LinkedList;
	
public class Run {
		
	public static void main(String[] args) {
			
				AlberoLf<String> albero = new AlberoLf<String>("Marco");
		
				NodoLf<String> nodoMarco = albero.getRadice();
				NodoLf<String> nodoClaudia = albero.nuovaRadice("Claudia");
				NodoLf<String> nodoSilvia = albero.aggiungiNodo(nodoMarco, "Silvia");
				NodoLf<String> nodoUgo = albero.aggiungiNodo(nodoMarco, "Ugo");
				NodoLf<String> nodoLuca = albero.aggiungiNodo(nodoClaudia, "Luca");
				NodoLf<String> nodoGiulia = albero.aggiungiNodo(nodoClaudia, "Giulia");
				NodoLf<String> nodoAndrea = albero.aggiungiNodo(nodoGiulia, "Andrea");
				NodoLf<String> nodoCarlo = albero.aggiungiNodo(nodoAndrea, "Carlo");
				NodoLf<String> nodoGianna = albero.aggiungiNodo(nodoGiulia, "Gianna");
					
		System.out.println("La stringa che lo rappresenta e': " + albero.toString());
	
		System.out.println("Numero nodi presenti nell'albero: " + albero.getnNodi());
	
		System.out.println("Altezza dell'albero: " + albero.getAltezza()); 
	
		System.out.println("Numero foglie dell'albero: " + albero.getNumeroFoglie());
	
		LinkedList<String> list1 = albero.visitaAmpiezza();
	
		LinkedList<String> list2 = albero.visitaProfondita();
	
		System.out.print("\nLista delle informazioni dei nodi dell’albero visitato in " + 
				"profondità: ");
			
			for (String stringa : list1) {
			System.out.print(stringa);
		}
	
		System.out.print("\n\nLista delle informazioni dei nodi dell’albero visitato in " + 
				"ampiezza: ");
	
			for (String stringa : list2) {
			System.out.print(stringa);
		}
	
	}
	
}

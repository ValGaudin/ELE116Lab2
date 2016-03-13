package VisiteurXML;

/**
 * Classe abstraite <b><i>Noeud</i></b><br><br>
 * Noeud est une classe qui permet de créer un objet hérité spécifique au type de noeud. 
 */
public abstract class Noeud implements NoeudIF {
	private Noeud parent;

	/**
	 * <b><i>definirParent</i></b> 
	 * permet de définir le parent de ce noeud.
	 * 
	 * @param noeud le noeud parent à définir
	 */
	public void definirParent (Noeud noeud) {
		this.parent = noeud;
	}
	
	/**
	 * <b><i>obtenirParent</i></b> 
	 * permet de retourner le parent du noeud.
	 * 
	 * @return Noeud le parent du noeud
	 */
	public Noeud obtenirParent() { 
		return parent; 
	}
}

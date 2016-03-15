package VisiteurXML;

/**
 * Classe abstraite <b><i>Noeud</i></b><br><br>
 * Noeud est une classe qui permet de créer un objet hérité spécifique au type de noeud. 
 */
public abstract class Noeud implements NoeudIF {
	private NoeudIF parent;

	/**
	 * <b><i>definirParent</i></b> 
	 * permet de définir le parent de ce noeud.
	 * 
	 * @param chapitre le noeud parent à définir
	 */
	public void definirParent (NoeudIF chapitre) {
		this.parent = chapitre;
	}
	
	/**
	 * <b><i>obtenirParent</i></b> 
	 * permet de retourner le parent du noeud.
	 * 
	 * @return Noeud le parent du noeud
	 */
	public NoeudIF obtenirParent() { 
		return parent; 
	}
}

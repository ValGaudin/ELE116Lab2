package VisiteurXML;

/**
 * Classe abstraite <b><i>Noeud</i></b><br><br>
 * Noeud est une classe qui permet de cr�er un objet h�rit� sp�cifique au type de noeud. 
 */
public abstract class Noeud implements NoeudIF {
	private NoeudIF parent;

	/**
	 * <b><i>definirParent</i></b> 
	 * permet de d�finir le parent de ce noeud.
	 * 
	 * @param chapitre le noeud parent � d�finir
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

package VisiteurXML;

public abstract class Noeud implements NoeudIF {
	private Noeud parent;

	public void definirParent (Noeud noeud) {
		this.parent = noeud;
	}

	public Noeud obtParent() { return parent; }
}

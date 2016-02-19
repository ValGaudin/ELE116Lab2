package VisiteurXML;

import java.util.ArrayList;
import java.util.List;

public abstract class Noeud implements NoeudIF {

	private Noeud parent;
	private List<Noeud> enfants;

	public Noeud() {
		this.parent = null;
		this.enfants = null;
	}

	public Noeud(Livre livre) {
		this.parent = livre;
		this.enfants = null;
	}

	public Noeud(Chapitre chapitre) {
		this.parent = chapitre;
		this.enfants = null;
	}

	void ajouterEnfant (Noeud noeud) {
		if (enfants == null)
			enfants = new ArrayList<Noeud>();
		noeud.parent = this;
		enfants.add(noeud);
	}

	public Noeud obtParent() { return parent; }

	public List<Noeud> obtEnfants() { return enfants; }

}

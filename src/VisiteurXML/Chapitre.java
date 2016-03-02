package VisiteurXML;

import java.util.ArrayList;
import java.util.List;

public class Chapitre extends Noeud {
	private List<Paragraphe> paragraphe;
	private String titre;

	public Chapitre(Livre livre) {
		super.definirParent(livre);
		paragraphe = new ArrayList<Paragraphe>();
		titre = "";
	}

	public void definirTitre(String titre){
		this.titre = titre;
	}
	
	public String obtenirTitre(){
		return titre;
	}

	public void ajouterParagraphe(Paragraphe paragraphe){
		this.paragraphe.add(paragraphe);
	}

	public void accept(VisiteurIF visiteur) {
		visiteur.visit(this);

		for(NoeudIF noeud : paragraphe){
			noeud.accept(visiteur);
		}
	}

}

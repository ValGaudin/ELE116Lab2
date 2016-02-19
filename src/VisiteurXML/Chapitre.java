package VisiteurXML;

import java.util.ArrayList;
import java.util.List;

public class Chapitre extends Noeud {
	List<Paragraphe> paragraphe;
	String titre;

	public Chapitre(Livre livre) {
		super(livre);
		paragraphe = new ArrayList<Paragraphe>();
		titre = "";
	}

	public void definirTitre(String titre){
		this.titre = titre;
	}

	public void ajouterParagraphe(Paragraphe paragraphe){
		super.ajouterEnfant(paragraphe);
		this.paragraphe.add(paragraphe);
	}

	public void accept(VisiteurIF visiteur) {
		visiteur.visit(this);

		for(NoeudIF noeud : this.obtEnfants()){
			noeud.accept(visiteur);
		}
	}

}

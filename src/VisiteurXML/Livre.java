package VisiteurXML;

import java.util.ArrayList;
import java.util.List;

public class Livre extends Noeud{
	private List<String> auteur;
	private List<Chapitre> chapitre;
	private String titre;

	public Livre() {
		super.definirParent(null);
		auteur = new ArrayList<String>();
		chapitre = new ArrayList<Chapitre>();
		titre = "";
	}

	public void ajouterAuteur(String auteur){
		this.auteur.add(auteur);
	}

	public void definirTitre(String titre){
		this.titre = titre;
	}

	public void ajouterChapitre(Chapitre chapitre){
		this.chapitre.add(chapitre);
	}

	public String obtenirTitre(){
		return titre;
	}
	
	public List<String> obtenirAuteur(){
		return auteur;
	}

	public void accept(VisiteurIF visiteur) {
		visiteur.visit(this);

		for(NoeudIF noeud : chapitre){
			noeud.accept(visiteur);
		}
	}


}

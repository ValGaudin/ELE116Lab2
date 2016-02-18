package VisiteurXML;

import java.util.ArrayList;
import java.util.List;

public class Livre extends Noeud{
	List<String> auteur;
	List<Chapitre> chapitre;
	String titre;
		
	public Livre() {
		super();
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
		super.ajouterEnfant(chapitre);
		this.chapitre.add(chapitre);
	}
	
	public String obtenirTitre(){
		return titre;
	}

	public void accept(VisiteurIF visiteur) {
		visiteur.visit(this);
		
		for(NoeudIF noeud : this.obtEnfants()){
			noeud.accept(visiteur);
		}
	}
	

}

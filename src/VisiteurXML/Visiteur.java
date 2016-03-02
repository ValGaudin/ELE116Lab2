package VisiteurXML;

import java.util.Iterator;
import java.util.List;

public abstract class Visiteur implements VisiteurIF {
	private static String texteHTML;
	private Iterator<String> iterator;

	public String obtenirTexteHTML(){
		return texteHTML;
	}
	
	public void debutTexteHTML(){
		texteHTML = "<HTML><TABLE WIDTH=100% HEIGHT=100% BORDER = 0 CELLSPACING=0 BGCOLOR=\"black\"><TR><TD ";
	}
	
	public void finTexteHTML(){
		texteHTML += "</TD></TR></TABLE></HTML>";
	}
	
	protected void affichageLivreEntierOuTabMat(String typeOptions){
		switch(typeOptions){
		case "TabMat" : texteHTML += "WIDTH=550 HEIGHT=620 BGCOLOR=\"yellow\" ALIGN=\"center\">"; 	break;
		case "Entier" : texteHTML += "COLSPAN = 3 BGCOLOR=\"yellow\" ALIGN=\"center\">";			break;
		}
	}

	protected void obtenirAuteur(Livre livre){
		List<String> auteur = livre.obtenirAuteur();
		
		if(auteur.size() > 0){
			iterator = auteur.iterator();
			while(iterator.hasNext()){
				texteItalique(iterator.next());
				sauterLigne();
			}
		}
	}

	protected void ajouterTexte(String texte){
		texteHTML += texte;
	}
	
	protected void texteGrosTitre(String texte){
		texteHTML += "<h1>" + texte + "</h1>";
	}

	protected void texteMoyenTitre(String texte){
		texteHTML += "<h2>" + texte + "</h2>";
	}

	protected void textePetitTitre(String texte){
		texteHTML += "<h3>" + texte + "</h3>";
	}

	protected void texteItalique(String texte){
		texteHTML += "<i>" + texte + "</i>";
	}

	protected void ajouterImageLivre(Livre livre){
		 if(livre.obtenirTitre().equals("Fables fameuses"))
			texteHTML += "<img src='file:images/imageLab2.jpg'/>";
	}
	
	protected void sauterLigne(){
		texteHTML += "<br/>";
	}
	
	protected void nouvelleColonne(){
		texteHTML += "</TD><TD BGCOLOR=\"orange\" ALIGN=\"center\">";
	}
	
	protected void nouvelleLigne(){
		texteHTML += "</TR><TR><TD BGCOLOR=\"orange\" ALIGN=\"center\">";
	}
}

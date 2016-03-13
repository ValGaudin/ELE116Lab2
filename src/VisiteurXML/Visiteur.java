package VisiteurXML;

import java.util.Iterator;
import java.util.List;

/**
 * Classe abstraite <b><i>Visiteur</i></b><br><br>
 * Visiteur est une classe qui permet de créer un objet hérité spécifique au type de visiteur.
 * De plus, cette classe contient toutes les méthodes de formatage HTML utilisées par ses enfants.
 * 
 * Remarque :
 * Pour des soucis d'esthétique, une solution par tableau a été choisie. 
 *
 **/
public abstract class Visiteur implements VisiteurIF {
	private static String texteHTML;
	private Iterator<String> iterator;
	
	/**
	 * <b><i>obtenirTexteHTML</i></b> 
	 * permet de retourner le texte formaté en HTML.
	 * 
	 * @return texte le texte formaté en HTML
	 */
	public String obtenirTexteHTML(){
		return texteHTML;
	}
	
	/**
	 * <b><i>debutTexteHTML</i></b> 
	 * permet d'initialiser le texte HTML
	 */
	protected void debutTexteHTML(){
		texteHTML = "<HTML><TABLE WIDTH=100% HEIGHT=100% BORDER = 0 CELLSPACING=0 BGCOLOR=\"black\"><TR><TD ";
	}

	/**
	 * <b><i>affichageLivreEntierOuTabMat</i></b> 
	 * permet de formater l'affichage selon la mise en page requise par le visiteur enfant.
	 * 
	 * @param typeOptions le type de mise en page
	 */
	protected void affichageLivreEntierOuTabMat(String typeOptions){
		switch(typeOptions){
		case "TabMat" : texteHTML += "WIDTH=550 HEIGHT=620 BGCOLOR=\"yellow\" ALIGN=\"center\">"; 	break;
		case "Entier" : texteHTML += "COLSPAN = 3 BGCOLOR=\"yellow\" ALIGN=\"center\">";			break;
		}
	}

	/**
	 * <b><i>formaterAuteur</i></b> 
	 * permet de formater l'affichage des auteurs.
	 * 
	 * @param livre le livre visité
	 */
	protected void formaterAuteur(Livre livre){
		List<String> auteur = livre.obtenirAuteur();
		
		if(auteur.size() > 0){
			iterator = auteur.iterator();
			while(iterator.hasNext()){
				texteItalique(iterator.next());
				sauterLigne();
			}
		}
	}

	/**
	 * <b><i>ajouterTexte</i></b> 
	 * permet d'ajouter du texte sans formatage.
	 * 
	 * @param texte le texte
	 */
	protected void ajouterTexte(String texte){
		texteHTML += texte;
	}
	
	/**
	 * <b><i>grosTitre</i></b> 
	 * permet de formater le texte en titre en police grosse.
	 * 
	 * @param texte le texte
	 */
	protected void grosTitre(String texte){
		texteHTML += "<h1>" + texte + "</h1>";
	}

	/**
	 * <b><i>moyenTitre</i></b> 
	 * permet de formater le texte en titre en police moyenne.
	 * 
	 * @param texte le texte
	 */
	protected void moyenTitre(String texte){
		texteHTML += "<h2>" + texte + "</h2>";
	}

	/**
	 * <b><i>petitTitre</i></b> 
	 * permet de formater le texte en titre en police petite.
	 * 
	 * @param texte le texte
	 */
	protected void petitTitre(String texte){
		texteHTML += "<h3>" + texte + "</h3>";
	}

	/**
	 * <b><i>texteItalique</i></b> 
	 * permet de formater le texte en italique.
	 * 
	 * @param texte le texte
	 */
	protected void texteItalique(String texte){
		texteHTML += "<i>" + texte + "</i>";
	}
	
	/**
	 * <b><i>texteGras</i></b> 
	 * permet de formater le texte en gras.
	 * 
	 * @param texte le texte
	 */
	protected void texteGras(String texte){
		texteHTML += "<b>" + texte + "</b>";
	}

	/**
	 * <b><i>ajouterImageLivre</i></b> 
	 * permet d'incruster l'image correspondante au livre selon le titre de ce dernier.
	 * 
	 * @param livre le livre visité
	 */
	protected void ajouterImageLivre(Livre livre){
		 if(livre.obtenirTitre().equals("Fables fameuses"))
			texteHTML += "<img src='file:images/imageLab2.jpg'/>";
		 else
			texteHTML += "Aucune image correspondante au livre n'a été trouvée !!";
	}
	
	/**
	 * <b><i>sauterLigne</i></b> 
	 * permet de sauter une ligne.
	 */
	protected void sauterLigne(){
		texteHTML += "<br/>";
	}
	
	/**
	 * <b><i>nouvelleColonne</i></b> 
	 * permet d'ajouter une nouvelle colonne à notre tableau.
	 */
	protected void nouvelleColonne(){
		texteHTML += "</TD><TD BGCOLOR=\"orange\" ALIGN=\"center\">";
	}
	
	/**
	 * <b><i>nouvelleLigne</i></b> 
	 * permet d'ajouter une nouvelle ligne à notre tableau.
	 */
	protected void nouvelleLigne(){
		texteHTML += "</TR><TR><TD BGCOLOR=\"orange\" ALIGN=\"center\">";
	}
}

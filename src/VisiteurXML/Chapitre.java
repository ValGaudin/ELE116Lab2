package VisiteurXML;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe <b><i>Chapitre</i></b> h�rit�e de {@link Noeud Noeud} <br><br>
 * Chapitre est une classe qui permet de cr�er un noeud qui contient une liste de paragraphes et un titre. 
 */
public class Chapitre extends Noeud {
	private List<NoeudIF> paragraphe;
	private String titre;

	/**
	 * Constructeur de la classe <b><i>Chapitre</i></b> 
	 * cr�e une nouvelle instance de la classe.
	 * 
	 * @param livre le parent du chapitre
	 */
	public Chapitre(NoeudIF livre) {
		super.definirParent(livre);
		paragraphe = new ArrayList<NoeudIF>();
		titre = "";
	}

	/**
	 * <b><i>ajouterParagraphe</i></b> 
	 * permet d'ajouter un paragraphe � ce chapitre.
	 * 
	 * @param paragraphe le paragraphe � ajouter
	 */
	public void ajouterParagraphe(NoeudIF paragraphe){
		this.paragraphe.add(paragraphe);
	}
	
	/**
	 * <b><i>definirTitre</i></b> 
	 * permet de d�finir le titre de ce chapitre.
	 * 
	 * @param titre le titre du chapitre � d�finir
	 */
	public void definirTitre(String titre){
		this.titre = titre;
	}
	
	/**
	 * <b><i>obtenirTitre</i></b> 
	 * permet de retourner le titre.
	 * 
	 * @return String le titre du chapitre
	 */
	public String obtenirTitre(){
		return titre;
	}

	/**
	 * <b><i>accepter</i></b> 
	 * permet de visiter le contenu de Chapitre et ses enfants (ici Paragraphe).
	 * 
	 * @param visiteur l'interface visiteur qui formate le texte
	 */
	public void accepter(VisiteurIF visiteur) {
		visiteur.visiter(this);

		for(NoeudIF noeud : paragraphe){
			noeud.accepter(visiteur);
		}
	}

}

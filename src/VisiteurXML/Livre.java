package VisiteurXML;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe <b><i>Livre</i></b> héritée de {@link Noeud Noeud} <br><br>
 *Livre est une classe qui permet de créer un noeud qui contient une liste de chapitres, d'auteurs et un titre. 
 */
public class Livre extends Noeud{
	private List<String> auteur;
	private List<Chapitre> chapitre;
	private String titre;

	/**
	 * Constructeur de la classe <b><i>Livre</i></b> 
	 * crée une nouvelle instance de la classe.
	 */
	public Livre() {
		super.definirParent(null);
		auteur = new ArrayList<String>();
		chapitre = new ArrayList<Chapitre>();
		titre = "";
	}

	/**
	 * <b><i>ajouterAuteur</i></b> 
	 * permet d'ajouter un auteur du livre.
	 * 
	 * @param auteur le nom de l'auteur
	 */
	public void ajouterAuteur(String auteur){
		this.auteur.add(auteur);
	}

	/**
	 * <b><i>ajouterChapitre</i></b> 
	 * permet d'ajouter un chapitre du livre.
	 * 
	 * @param chapitre le chapitre à ajouter
	 */
	public void ajouterChapitre(Chapitre chapitre){
		this.chapitre.add(chapitre);
	}
	
	/**
	 * <b><i>definirTitre</i></b> 
	 * permet de définir le titre de ce livre.
	 * 
	 * @param titre le titre du livre à définir
	 */
	public void definirTitre(String titre){
		this.titre = titre;
	}
	
	/**
	 * <b><i>obtenirTitre</i></b> 
	 * permet de retourner le titre du livre.
	 * 
	 * @return List of String la liste des auteurs du livre
	 */
	public List<String> obtenirAuteur(){
		return auteur;
	}

	/**
	 * <b><i>obtenirTitre</i></b> 
	 * permet de retourner le titre du livre.
	 * 
	 * @return String le titre du livre
	 */
	public String obtenirTitre(){
		return titre;
	}

	/**
	 * <b><i>accepter</i></b> 
	 * permet de visiter le contenu de Livre et ses enfants (ici Chapitre).
	 * 
	 * @param visiteur l'interface visiteur qui formate le texte
	 */
	public void accepter(VisiteurIF visiteur) {
		visiteur.visiter(this);

		for(NoeudIF noeud : chapitre){
			noeud.accepter(visiteur);
		}
	}
}

package VisiteurXML;

/**
 * Classe <b><i>VisiteurTabMat</i></b> héritée de {@link Visiteur Visiteur} <br><br>
 * VisiteurTabMat est une classe qui permet de créer un visiteur qui formatera le livre en format HTML
 * selon l'affichage "Livre entier". 
 */
public class VisiteurEntier extends Visiteur{
	//Entier contenant le nombre de paragraphe affiché (pour la gestion des colonnes)
	private int nbPara = 0;

	/**
	 * <b><i>visiter</i></b> 
	 * permet de visiter un Livre pour créer une version HTLM de son contenu.
	 * 
	 * @param livre le livre à visiter
	 */
	public void visiter(Livre livre) {
		debutTexteHTML();
		affichageLivreEntierOuTabMat("Entier");
		grosTitre(livre.obtenirTitre());
		petitTitre("Auteurs");
		formaterAuteur(livre);
		nouvelleLigne();
	}

	/**
	 * <b><i>visiter</i></b> 
	 * permet de visiter un Chapitre pour créer une version HTLM de son contenu.
	 * 
	 * @param chapitre le chapitre à visiter
	 */
	public void visiter(Chapitre chapitre) {
		nbPara++;
		sauterLigne();
		if(nbPara % 4 == 0){
			nouvelleColonne();
			ajouterImageLivre((Livre) chapitre.obtenirParent());
			nouvelleColonne();
		}
		
		moyenTitre(chapitre.obtenirTitre());
	}

	/**
	 * <b><i>visiter</i></b> 
	 * permet de visiter un Paragraphe pour créer une version HTLM de son contenu.
	 * (ici, elle est vide car une table des matières ne comporte pas de paragraphe !).
	 * 
	 * @param paragraphe le paragraphe à visiter
	 */
	public void visiter(Paragraphe paragraphe) {
		ajouterTexte(paragraphe.obtenirParagraphe());
		sauterLigne();
	}
}

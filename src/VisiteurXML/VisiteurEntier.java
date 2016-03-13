package VisiteurXML;

/**
 * Classe <b><i>VisiteurTabMat</i></b> h�rit�e de {@link Visiteur Visiteur} <br><br>
 * VisiteurTabMat est une classe qui permet de cr�er un visiteur qui formatera le livre en format HTML
 * selon l'affichage "Livre entier". 
 */
public class VisiteurEntier extends Visiteur{
	//Entier contenant le nombre de paragraphe affich� (pour la gestion des colonnes)
	private int nbPara = 0;

	/**
	 * <b><i>visiter</i></b> 
	 * permet de visiter un Livre pour cr�er une version HTLM de son contenu.
	 * 
	 * @param livre le livre � visiter
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
	 * permet de visiter un Chapitre pour cr�er une version HTLM de son contenu.
	 * 
	 * @param chapitre le chapitre � visiter
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
	 * permet de visiter un Paragraphe pour cr�er une version HTLM de son contenu.
	 * (ici, elle est vide car une table des mati�res ne comporte pas de paragraphe !).
	 * 
	 * @param paragraphe le paragraphe � visiter
	 */
	public void visiter(Paragraphe paragraphe) {
		ajouterTexte(paragraphe.obtenirParagraphe());
		sauterLigne();
	}
}

package VisiteurXML;

/**
 * Classe <b><i>VisiteurTabMat</i></b> h�rit�e de {@link Visiteur Visiteur} <br><br>
 * VisiteurTabMat est une classe qui permet de cr�er un visiteur qui formatera le livre en format HTML
 * selon l'affichage "Table des mati�res". 
 */
public class VisiteurTabMat extends Visiteur{
	/**
	 * <b><i>visiter</i></b> 
	 * permet de visiter un Livre pour cr�er une version HTLM de son contenu.
	 * 
	 * @param livre le livre � visiter
	 */
	public void visiter(Livre livre) {
		debutTexteHTML();
		affichageLivreEntierOuTabMat("TabMat");
		ajouterImageLivre(livre);
		nouvelleColonne();
		grosTitre(livre.obtenirTitre());
		sauterLigne();
		texteGras("Auteurs");
		sauterLigne();
		formaterAuteur(livre);
		sauterLigne();
	}

	/**
	 * <b><i>visiter</i></b> 
	 * permet de visiter un Chapitre pour cr�er une version HTLM de son contenu.
	 * 
	 * @param chapitre le chapitre � visiter
	 */
	public void visiter(Chapitre chapitre) {
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
		//Do nothing
	}
}

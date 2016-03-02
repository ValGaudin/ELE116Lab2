package VisiteurXML;

public class VisiteurTabMat extends Visiteur{

	public void visit(Livre livre) {
		debutTexteHTML();
		affichageLivreEntierOuTabMat("TabMat");
		ajouterImageLivre(livre);
		nouvelleColonne();
		texteGrosTitre(livre.obtenirTitre());
	}

	public void visit(Chapitre chapitre) {
		texteMoyenTitre(chapitre.obtenirTitre());
	}

	public void visit(Paragraphe paragraphe) {
		//Do nothing
	}
}

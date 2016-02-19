package VisiteurXML;

public class VisiteurTabMat extends Visiteur{

	public void visit(Livre livre) {
		debutTexteHTML();
		ajouterImageLivre(livre);
		nouvelleColonne();
		texteGrosTitre(livre.titre);
	}

	public void visit(Chapitre chapitre) {
		texteMoyenTitre(chapitre.titre);
	}

	public void visit(Paragraphe paragraphe) {
		//Do nothing
	}
}

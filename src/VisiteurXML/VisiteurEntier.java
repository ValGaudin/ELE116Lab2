package VisiteurXML;

public class VisiteurEntier extends Visiteur{
	int nbParaCol = 1;

	public void visit(Livre livre) {
		debutTexteHTML();
		affichageLivreEntierOuTabMat("Entier");
		texteGrosTitre(livre.titre);
		textePetitTitre("Auteurs");
		obtenirAuteur(livre);
		nouvelleLigne();
	}

	public void visit(Chapitre chapitre) {
		sauterLigne();
		if(nbParaCol % 4 == 0){
			nouvelleColonne();
			ajouterImageLivre((Livre) chapitre.obtParent());
			nouvelleColonne();
		}
		
		texteMoyenTitre(chapitre.titre);
		nbParaCol++;
	}

	public void visit(Paragraphe paragraphe) {
		ajouterTexte(paragraphe.paragraphe);
		sauterLigne();
	}
}

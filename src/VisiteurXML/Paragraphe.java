package VisiteurXML;

public class Paragraphe extends Noeud{
	private String paragraphe;

	public Paragraphe(Chapitre chapitre) {
		super.definirParent(chapitre);
		paragraphe = "";
	}

	public void definirParagraphe(String paragraphe){
		this.paragraphe = paragraphe;
	}
	
	public String obtenirParagraphe(){
		return paragraphe;
	}

	public void accept(VisiteurIF visiteur) {
		visiteur.visit(this);
	}

}

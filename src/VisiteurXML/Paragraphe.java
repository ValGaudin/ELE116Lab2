package VisiteurXML;

public class Paragraphe extends Noeud{
	String paragraphe;

	public Paragraphe(Chapitre chapitre) {
		super(chapitre);
		paragraphe = "";
	}
	
	public void definirParagraphe(String paragraphe){
		this.paragraphe = paragraphe;
	}

	public void accept(VisiteurIF visiteur) {
		visiteur.visit(this);
	}

}

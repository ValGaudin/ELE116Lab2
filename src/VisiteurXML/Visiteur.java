package VisiteurXML;

public abstract class Visiteur implements VisiteurIF {
	static String HTML;
	
	public abstract void visit(NoeudIF noeud);
	
	public String obtenirHTML(){
		return HTML;
	}
}

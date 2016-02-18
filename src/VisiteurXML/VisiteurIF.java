package VisiteurXML;

public interface VisiteurIF {
	public void visit(NoeudIF noeud);
	public void visit(Livre livre);
	public void visit(Chapitre chapitre);
	public void visit(Paragraphe paragraphe);
	public String obtenirHTML();
}

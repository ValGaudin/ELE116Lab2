package VisiteurXML;

public interface VisiteurIF {
	public void visit(Livre livre);
	public void visit(Chapitre chapitre);
	public void visit(Paragraphe paragraphe);
	public String obtenirTexteHTML();
	public void finTexteHTML();
	public void debutTexteHTML();
}

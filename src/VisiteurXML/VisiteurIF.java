package VisiteurXML;

/**
 * Interface <b><i>VisiteurIF</i></b> implémentée par {@link VisiteurEntier VisiteurEntier} et {@link VisiteurTabMat VisiteurTabMat}<br><br>
 * VisiteurIF est une classe qui permet de faire l'interface entre le visiteur et le reste du programme. 
 */
public interface VisiteurIF {
	public void visiter(Livre livre);
	public void visiter(Chapitre chapitre);
	public void visiter(Paragraphe paragraphe);
	public String obtenirTexteHTML();
}

package VisiteurXML;

/**
 * Classe <b><i>NoeudIF</i></b> implémentée par { {@link Noeud Noeud} <br><br>
 * NoeudIF est une classe qui permet de l'interface entre un noeud et le reste du programme.
 */
public interface NoeudIF {
	public void accepter(VisiteurIF visiteur);
}

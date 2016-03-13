package VisiteurXML;

/**
 * Classe <b><i>Paragraphe</i></b> héritée de {@link Noeud Noeud} <br><br>
 * Paragraphe est une classe qui permet de créer un noeud qui contient un paragraphe. 
 */
public class Paragraphe extends Noeud{
	private String paragraphe;

	/**
	 * Constructeur de la classe <b><i>Paragraphe</i></b> 
	 * crée une nouvelle instance de la classe.
	 * 
	 * @param chapitre un le chapitre du livre
	 */
	public Paragraphe(Chapitre chapitre) {
		super.definirParent(chapitre);
		paragraphe = "";
	}

	/**
	 * <b><i>definirParagraphe</i></b> 
	 * permet de définir le contenu de ce paragraphe.
	 * 
	 * @param paragraphe le contenu du paragraphe à définir
	 */
	public void definirParagraphe(String paragraphe){
		this.paragraphe = paragraphe;
	}
	
	/**
	 * <b><i>obtenirParagraphe</i></b> 
	 * permet de retourner le paragraphe.
	 * 
	 * @return Paragraphe le paragraphe
	 */
	public String obtenirParagraphe(){
		return paragraphe;
	}

	/**
	 * <b><i>accepter</i></b> 
	 * permet de visiter le contenu de Paragraphe.
	 * 
	 * @param visiteur l'interface visiteur qui formate le texte
	 */
	public void accepter(VisiteurIF visiteur) {
		visiteur.visiter(this);
	}

}

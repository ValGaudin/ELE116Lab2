package VisiteurXML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Classe  <b><i>LecteurXML</i></b><br><br>
 * LecteurXML est une classe qui permet de lire un fichier XML et g�n�rer son arbre de donn�es. 
 * 
 */
public class LecteurXML {
	//Objets n�cessaires au LecteurXML
	private static List<NoeudIF> listeLivre;
	private static MyHandler handler;
	private NoeudIF livreCourant;

	/**
	 * Constructeur de la classe <b><i>Lecteur XML</i></b> 
	 * cr�e une nouvelle instance de la classe interne.
	 */
	public LecteurXML(){
		handler = new MyHandler();
	}

	/**
	 * <b><i>lireXML</i></b> 
	 * permet de lire le contenu du fichier XML et g�n�rer des �v�nements.
	 * (Balise d'ouverture trouv�e par exemple)
	 * 
	 * @param XML le fichier XML � lire
	 */
	public static void lireXML(File XML){
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			saxParser.parse(XML, handler);

		} catch (SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b><i>ajouterLivre</i></b> 
	 * permet d'ajouter le livre lu � la liste de livre lu.
	 * 
	 * @param livre le fichier lu
	 */
	public void ajouterLivre(NoeudIF livre){
		if(listeLivre == null)
			listeLivre = new ArrayList<NoeudIF>();
		
		listeLivre.add(livre);
		definirLivreCourant(livre);
	}

	/**
	 * <b><i>definirLivreCourant</i></b> 
	 * permet de d�finir le livre � afficher.
	 * 
	 * @param livre le dernier livre lu
	 */
	private void definirLivreCourant(NoeudIF livre){
		this.livreCourant = livre;
	}
	
	/**
	 * <b><i>obtenirListeLivre</i></b> 
	 * permet d'obtenir la liste de livre lu.
	 * 
	 * @return List of NoeudIF la liste des livres lus
	 */
	public List<NoeudIF> obtenirListeLivre(){
		return listeLivre;
	}

	/**
	 * <b><i>obtenirLivreCourant</i></b> 
	 * permet d'obtenir le dernier livre de la liste de livre lu.
	 * 
	 * @return NoeudIF le dernier livre lu
	 */
	public NoeudIF obtenirLivreCourant(){
		return livreCourant;
	}
	
	/**
	 * <b><i>obtenirLivre</i></b> 
	 * permet d'obtenir le livre recherch� dans la liste de livre lu.
	 * 
	 * @param titre le titre du livre recherch�
	 * @return NoeudIF le livre recherch�
	 */
	public NoeudIF obtenirLivre(String titre){
		Livre livre = null;
		Iterator<NoeudIF> iterator = listeLivre.iterator();

		while(iterator.hasNext()){
			livre = (Livre) iterator.next();
			if(livre.obtenirTitre().equals(titre)){
				break;
			}
		}

		return livre;
	}

	/**
	 * Classe interne <b><i>MyHandler</i></b><br><br>
	 * MyHandler est une classe qui permet de r��crire les m�thodes h�rit�e de la classe DefaultHandler 
	 * et les adapter nos sp�cificit�s. 
	 */
	private class MyHandler extends DefaultHandler {
		//Objets qui repr�sentent les �l�ments qu'on devrait trouver dans le fichier XML
		private Livre livre;
		private Chapitre chapitre;
		private Paragraphe paragraphe;

		//Bool�ens qui repr�sentent l'avertissement de trouvaille des �l�ments recherch�s
		private boolean bTitreLivre = false;
		private boolean bLivre = false;
		private boolean bAuteur = false;
		private boolean bChapitre = false;
		private boolean bTitreChapitre = false;
		private boolean bParagraphe = false;
		
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {

			if (qName.equalsIgnoreCase("livre")) {
				bLivre = true;
				
			} else if (qName.equalsIgnoreCase("titre_livre")) {
				bTitreLivre = true;
				
			} else if (qName.equalsIgnoreCase("auteur")) {
				bAuteur = true;
				
			} else if (qName.equalsIgnoreCase("chapitre")) {
				bChapitre = true;
				
			} else if (qName.equalsIgnoreCase("titre_chapitre")) {
				bTitreChapitre = true;
				
			} else if (qName.equalsIgnoreCase("paragraphe")) {
				bParagraphe = true;
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equalsIgnoreCase("livre")) {
				ajouterLivre(livre);
				
			}else if (qName.equalsIgnoreCase("chapitre")) {
				livre.ajouterChapitre(chapitre);
			}
		}

		@Override
		public void characters(char ch[], int start, int length) throws SAXException {

			if (bLivre) {
				livre = new Livre();
				bLivre = false;

			} else if (bTitreLivre) {
				livre.definirTitre(new String(ch, start, length));
				bTitreLivre = false;

			} else if (bAuteur) {
				livre.ajouterAuteur(new String(ch, start, length));
				bAuteur = false;

			} else if (bChapitre) {
				chapitre = new Chapitre(livre);
				bChapitre = false;

			} else if (bTitreChapitre) {
				chapitre.definirTitre(new String(ch, start, length));
				bTitreChapitre = false;

			} else if (bParagraphe){
				paragraphe = new Paragraphe(chapitre);
				paragraphe.definirParagraphe(new String(ch, start, length));
				chapitre.ajouterParagraphe(paragraphe);
				bParagraphe = false;
			}
		}
	}
}


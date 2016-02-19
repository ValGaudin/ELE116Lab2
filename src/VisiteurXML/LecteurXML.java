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

public class LecteurXML {

	private static List<Livre> listeLivre;
	private static MyHandler handler;
	private Livre livreCourant;

	public LecteurXML(){
		handler = new MyHandler();
	}

	public static void lireXML(File XML){
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			saxParser.parse(XML, handler);

		} catch (SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}
	}

	public void ajouterLivre(Livre livre){
		if(listeLivre == null)
			listeLivre = new ArrayList<Livre>();
		listeLivre.add(livre);
		definirLivreCourant(livre);
	}

	private void definirLivreCourant(Livre livre){
		this.livreCourant = livre;
	}

	public List<Livre> obtenirListeLivre(){
		return listeLivre;
	}

	public Livre obtenirLivreCourant(){
		return livreCourant;
	}

	public Livre obtenirLivre(String titre){
		Livre livre = null;
		Iterator<Livre> iterator = listeLivre.iterator();

		while(iterator.hasNext()){
			livre = iterator.next();
			if(iterator.next().titre.equals(titre)){
				break;
			}
		}

		return livre;
	}

	public class MyHandler extends DefaultHandler {

		public Livre livre;
		public Chapitre chapitre;
		public Paragraphe paragraphe;

		boolean bTitreLivre = false;
		boolean bLivre = false;
		boolean bAuteur = false;
		boolean bChapitre = false;
		boolean bTitreChapitre = false;
		boolean bParagraphe = false;

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
				paragraphe.paragraphe = new String(ch, start, length);
				chapitre.ajouterParagraphe(paragraphe);
				bParagraphe = false;
			}
		}
	}
}


package VisiteurXML;

import java.util.Iterator;

public class VisiteurEntier extends Visiteur{

	Iterator<String> iterator;
	Object o;

	public void visit(Livre livre) {
		HTML = "<h1>" + livre.titre + "</h1><br>";
		HTML += "<h2>Auteurs : </h2>";
		if(livre.auteur.size() > 0){
			iterator = livre.auteur.iterator();
			while(iterator.hasNext()){
				HTML += "<i>" + iterator.next() + "</i><br>";
			}
		}
	}

	public void visit(Chapitre chapitre) {
		HTML += "<br>";
		HTML += "<h2>" + chapitre.titre + "</h2>";
	}

	public void visit(Paragraphe paragraphe) {
		HTML += paragraphe.paragraphe + "<br>";
	}

	public void visit(NoeudIF noeud) {
		//		if(noeud instanceof Livre){
		//			((Livre) noeud).accept(this);
		//		}else if(noeud instanceof Chapitre){
		//			((Chapitre) noeud).accept(this);
		//		}else if(noeud instanceof Paragraphe){
		//			((Paragraphe) noeud).accept(this);
		//		}
	}
}

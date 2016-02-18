package VisiteurXML;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Affichage extends JFrame implements ActionListener {
	JFrame frame = new JFrame();
	JEditorPane pane = new JEditorPane();
	JMenuBar menuBar = new JMenuBar();
	JScrollPane scroll = new JScrollPane(pane);
	LecteurXML lecteur = new LecteurXML();
	VisiteurIF visiteur;
	NoeudIF noeud;
	
	JMenu boutonFichier = new JMenu("Fichier"), 
		  boutonOptions = new JMenu("Options");
	
	JMenuItem sousBoutonOuvrir = new JMenuItem("Ouvrir fichier XML"), 
			  sousBoutonTable = new JMenuItem("Table des matières"), 
			  sousBoutonLivre =new JMenuItem("Livre entier");

	public Affichage(){
		sousBoutonOuvrir.addActionListener(this);
		sousBoutonTable.addActionListener(this);
		sousBoutonLivre.addActionListener(this);

		frame.setSize(700, 700);
		frame.setLocationRelativeTo(null);

		boutonFichier.add(sousBoutonOuvrir);
		boutonOptions.add(sousBoutonTable);
		boutonOptions.add(sousBoutonLivre);

		menuBar.add(boutonFichier);
		menuBar.add(boutonOptions);

		frame.setJMenuBar(menuBar);

		pane.setContentType("text/html");
		
		frame.add(scroll);
		frame.setVisible(true);
	}

	public static void main(String[] args) throws Throwable
	{
		new Affichage();
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(sousBoutonOuvrir)){
			System.out.println(arg0.getActionCommand());
			
			ouvrirFichier();
			lecteur = new LecteurXML();
			noeud = lecteur.obtenirLivreCourant();
			
		}else if(arg0.getSource().equals(sousBoutonTable)){
			System.out.println(arg0.getActionCommand());
			
			visiteur = new VisiteurTabMat();
			noeud.accept(visiteur);
			pane.setText(visiteur.obtenirHTML());

		}else if(arg0.getSource().equals(sousBoutonLivre)){
			System.out.println(arg0.getActionCommand());
			
			visiteur = new VisiteurEntier();
			noeud.accept(visiteur);
			pane.setText(visiteur.obtenirHTML());
		}
	}
	
	void ouvrirFichier(){
		JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.home") + File.separator + "Downloads"));
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
	    chooser.setFileFilter(filter);
	   
	    int returnVal = chooser.showOpenDialog(frame);
	    
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       LecteurXML.lireXML(chooser.getSelectedFile());
	    }
	}
}

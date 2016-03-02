package VisiteurXML;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
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

		frame.setSize(1100, 690);
		frame.setLocationRelativeTo(null);
		

		boutonFichier.add(sousBoutonOuvrir);
		boutonOptions.add(sousBoutonTable);
		boutonOptions.add(sousBoutonLivre);

		menuBar.add(boutonFichier);
		menuBar.add(boutonOptions);

		frame.setJMenuBar(menuBar);

		pane.setContentType("text/html");
		pane.setEditable(false);

		frame.add(scroll);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			noeud = lecteur.obtenirLivreCourant();

		}else{ 
			if(arg0.getSource().equals(sousBoutonTable)){
				System.out.println(arg0.getActionCommand());

				visiteur = new VisiteurTabMat();

			}else if(arg0.getSource().equals(sousBoutonLivre)){
				System.out.println(arg0.getActionCommand());

				visiteur = new VisiteurEntier();
			}
			
			formaterTexteArbre(noeud, visiteur);
			pane.setText(visiteur.obtenirTexteHTML());
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
	
	public void formaterTexteArbre(NoeudIF noeud, VisiteurIF visiteur){
		visiteur.debutTexteHTML();
		noeud.accept(visiteur);
		visiteur.finTexteHTML();
	}
}

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

/**
 * Classe <b><i>Affichage</i></b> <br><br>
 * 
 * Affichage est une classe qui permet d'afficher le contenu d'un fichier XML
 * dans une fenêtre selon une certaine mise en page. 
 */
@SuppressWarnings("serial")
public class Affichage extends JFrame implements ActionListener {
	//Objets nécessaires à l'affichage
	private JFrame frame = new JFrame();
	private JEditorPane pane = new JEditorPane();
	private JMenuBar menuBar = new JMenuBar();
	private JScrollPane scroll = new JScrollPane(pane);
	private LecteurXML lecteur = new LecteurXML();
	private VisiteurIF visiteur;
	private NoeudIF noeud;

	//Boutons principaux du menu
	private JMenu Fichier = new JMenu("Fichier"), 
				  Options = new JMenu("Options");

	//Sous-Boutons du menu
	private JMenuItem BoutonOuvrir = new JMenuItem("Ouvrir fichier XML"), 
			  		  BoutonTable  = new JMenuItem("Table des matières"), 
			  		  BoutonLivre  = new JMenuItem("Livre entier");

	/**
	 * Constructeur de la classe <b><i>Affichage</i></b> 
	 * initialise tout notre fenêtre.
	 */
	public Affichage(){
		BoutonOuvrir.addActionListener(this);
		BoutonTable.addActionListener(this);
		BoutonLivre.addActionListener(this);

		frame.setSize(1100, 690);
		frame.setLocationRelativeTo(null);
		
		Fichier.add(BoutonOuvrir);
		Options.add(BoutonTable);
		Options.add(BoutonLivre);

		menuBar.add(Fichier);
		menuBar.add(Options);

		frame.setJMenuBar(menuBar);

		pane.setContentType("text/html");	
		pane.setText("<HTML><TABLE WIDTH=100% HEIGHT=100% BORDER = 0 CELLSPACING=0><TR><TD ALIGN=\"center\"><h1>Pour visionner un livre,<br> "
					 + "veuillez sélectionner le fichier XML lui correspondant via \"Fichier\".</h1></TD></TR></TABLE></HTML>");
		pane.setEditable(false);

		frame.add(scroll);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * <b><i>actionPerformed</i></b> 
	 * permet de récupérer l'action produite par l'utilisateur et la traiter.
	 * 
	 * @param action l'action produite par l'utilisateur
	 */
	public void actionPerformed(ActionEvent action) {
		//L'utilisateur a appuyé sur Ouvrir fichier XML
		if(action.getSource().equals(BoutonOuvrir)){
			ouvrirFichier();
			noeud = lecteur.obtenirLivreCourant();
			pane.setText("<HTML><TABLE WIDTH=100% HEIGHT=100% BORDER = 0 CELLSPACING=0><TR><TD ALIGN=\"center\"><h1>Le livre sélectionné a été généré.<br>"
						 + "Veuillez choisir un mode d'affichage pour visionner son contenu via  le  \"Options\".</h1></TD></TR></TABLE></HTML>");
		
		}else{ 
			//L'utilisateur a appuyé sur Table des matières
			if(action.getSource().equals(BoutonTable)){
				visiteur = new VisiteurTabMat();
			
				//L'utilisateur a appuyé sur Livre entier
			}else if(action.getSource().equals(BoutonLivre)){
				visiteur = new VisiteurEntier();
			}
			
			formaterTexteArbre(noeud, visiteur);
			//Affichage voulu
			pane.setText(visiteur.obtenirTexteHTML());
		}
	}

	/**
	 * <b><i>ouvrirFichier</i></b> 
	 * permet d'ouvrir une boîte de dialogue dans le dossier Downloads de l'ordinateur 
	 * et filtrer tous les fichiers sauf les XML.
	 * 
	 */
	void ouvrirFichier(){
		JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.home") + File.separator + "Downloads"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
		chooser.setFileFilter(filter);

		int returnVal = chooser.showOpenDialog(frame);

		if(returnVal == JFileChooser.APPROVE_OPTION) {
			LecteurXML.lireXML(chooser.getSelectedFile());
		}
	}
	
	/**
	 * <b><i>formaterTexteArbre</i></b> 
	 * permet de formateur l'arbre de données selon la mise en page voulue.
	 * 
	 * @param noeud la racine de l'arbre de données
	 * @param visiteur la mise en page voulue
	 */
	public void formaterTexteArbre(NoeudIF noeud, VisiteurIF visiteur){
		noeud.accepter(visiteur);
	}
	
	/**
	 * <b><i>main</i></b> 
	 * permet de rouler l'application.
	 * 
	 * @param args les throwables
	 */
	public static void main(String[] args)
	{
		new Affichage();
	}
}

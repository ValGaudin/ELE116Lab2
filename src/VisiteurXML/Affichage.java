package VisiteurXML;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Affichage extends JFrame implements ActionListener {
	JFrame jFrame = new JFrame();
	JEditorPane jEditorPane = new JEditorPane();
	JMenuBar jMenuBar = new JMenuBar();
	
	JMenu boutonFichier = new JMenu("Fichier"), 
		  boutonOptions = new JMenu("Options");
	
	JMenuItem sousBoutonOuvrir = new JMenuItem("Ouvrir fichier XML"), 
			  sousBoutonTable = new JMenuItem("Table des matières"), 
			  sousBoutonLivre =new JMenuItem("Livre entier");

	public Affichage(){
		sousBoutonOuvrir.addActionListener(this);
		sousBoutonTable.addActionListener(this);
		sousBoutonLivre.addActionListener(this);

		jFrame.setSize(700, 700);
		jFrame.setLocationRelativeTo(null);

		boutonFichier.add(sousBoutonOuvrir);
		boutonOptions.add(sousBoutonTable);
		boutonOptions.add(sousBoutonLivre);

		jMenuBar.add(boutonFichier);
		jMenuBar.add(boutonOptions);

		jFrame.setJMenuBar(jMenuBar);

		jEditorPane.setContentType("text/html");
		jEditorPane.setText("Toto");

		jFrame.add(jEditorPane);

		jFrame.setVisible(true);
	}

	public static void main(String[] args) throws Throwable
	{
		new Affichage();
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(sousBoutonOuvrir)){
			System.out.println(arg0.getActionCommand());

		}else if(arg0.getSource().equals(sousBoutonTable)){
			System.out.println(arg0.getActionCommand());

		}else if(arg0.getSource().equals(sousBoutonLivre)){
			System.out.println(arg0.getActionCommand());
		}
	}
}

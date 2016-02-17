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
	JMenu[] jMenu = {new JMenu("Fichier"), new JMenu("Afficher")};
	JMenuItem[] jMenuItem = {new JMenuItem("Ouvrir fichier XML"), 
			new JMenuItem("Table des matières"), 
			new JMenuItem("Livre entier")};

	public Affichage(){
		jMenuItem[0].addActionListener(this);
		jMenuItem[1].addActionListener(this);
		jMenuItem[2].addActionListener(this);

		jFrame.setSize(700, 700);
		jFrame.setLocationRelativeTo(null);

		jMenu[0].add(jMenuItem[0]);
		jMenu[1].add(jMenuItem[1]);
		jMenu[1].add(jMenuItem[2]);

		jMenuBar.add(jMenu[0]);
		jMenuBar.add(jMenu[1]);

		jFrame.setJMenuBar(jMenuBar);

		jEditorPane.setContentType("text/html");
		jEditorPane.setText("Toto");

		jFrame.add(jEditorPane);

		jMenuItem[0].setVisible(true);
		jMenuItem[1].setVisible(true);
		jMenu[0].setVisible(true);
		jMenu[0].setVisible(true);
		jMenuBar.setVisible(true);
		jFrame.setVisible(true);
		jEditorPane.setVisible(true);
	}

	public static void main(String[] args) throws Throwable
	{
		new Affichage();
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(jMenuItem[0])){
			System.out.println(arg0.getActionCommand());
			
		}else if(arg0.getSource().equals(jMenuItem[1])){
			System.out.println(arg0.getActionCommand());
			
		}else if(arg0.getSource().equals(jMenuItem[2])){
			System.out.println(arg0.getActionCommand());
		}
	}
}

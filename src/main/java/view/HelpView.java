package view;

import java.awt.*;
import javax.swing.*;

public class HelpView extends JFrame {

	JTextArea textArea = new JTextArea(
	  "                                                       \n"
	+ " Calculator de polinoame - Instrucțiuni de utilizare\n"
	+ "                                                       \n"
	+ " ==============================================\n"
	+ " Calculatorul de polinoame permite realizarea operațiilor\n"
	+ " de adunare, scădere, înmulțire, împărțire, integrare și\n"
	+ " derivare a polinoamelor.\n"
	+ "                                                       \n"
	+ " Pentru a utiliza operațiile de adunare, scădere,\n"
	+ " înmulțire și împărțire, este necesară introducerea de\n"
	+ " polinoame în ambele câmpuri.\n"
	+ "                                                       \n"
	+ " Pentru a utiliza operațiile de integrare și derivare,\n"
	+ " introduceți un polinom doar în primul câmp.\n"
	+ "                                                       \n"
	+ " Termenii polinoamelor pot fi introduși în orice ordine.\n"
	+ " Formatul care trebuie utilizat este următorul:\n"
	+ "                                                       \n"
	+ "                       [coeficient](X sau x)^(putere) +/- ...\n"
	+ "                                                       \n"
	+ " [ ] - obligatoriu\n"
	+ " - Coeficientul trebuie introdus obligatoriu\n"
	+ " (ex: X^4 se va scrie 1X^4)\n"
	+ "                                                       \n"
	+ " ( ) - opțional\n"
	+ " - În cazul puterii 1 și a termenilor liberi\n"
	+ " ==============================================\n"
	+ "                                                       \n"
	+ " v1.0 - David Alex Ducai, Martie 2021\n"
	);
			
	JPanel closePanel = new JPanel();
	public JButton closeButton = new JButton("OK");
	
	public HelpView(){
		
		this.setTitle("Ajutor");
		this.setSize(438,680);
		this.setLayout(new BorderLayout());
		
		textArea.setEditable(false);
		textArea.setHighlighter(null);
		textArea.setFont(new Font("",Font.BOLD,15));
		
		closePanel.add(closeButton);
		this.add(textArea,BorderLayout.CENTER);
		this.add(closePanel,BorderLayout.SOUTH);
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

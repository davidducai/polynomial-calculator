package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class CalculatorView extends JFrame {

	JLabel titleLabel = new JLabel("Calculator de polinoame",SwingConstants.CENTER);
	JLabel resultLabel = new JLabel("Rezultat:");
	
	public JPanel firstPanel = new JPanel();
	public JPanel secondPanel = new JPanel();
	public JPanel resultPanel = new JPanel();
	JPanel operationsPanel = new JPanel();
	
	public JTextField firstField = new JTextField();
	public JTextField secondField = new JTextField();
	public JTextField resultField = new JTextField();
	
	public JButton addButton = new JButton("Adunare");
	public JButton subButton = new JButton("Scădere");
	public JButton mulButton = new JButton("Înmulțire");
	public JButton divButton = new JButton("Împărțire");
	public JButton intButton = new JButton("Integrare");
	public JButton derButton = new JButton("Derivare");
	public JButton clrButton = new JButton("Ștergere");
	public JButton helpButton = new JButton("Ajutor");
	
	Font textFieldFont = new Font("",Font.PLAIN,20);
	
	Dimension fieldDimension = new Dimension(400,75);
	
	Color defaultColor = UIManager.getColor("Panel.background");
	
	public CalculatorView(){
		
		this.setTitle("Calculator");
		this.setLayout(new GridLayout(5,1));
		this.setSize(new Dimension(500,600));
		
		titleLabel.setFont(new Font("",Font.BOLD,18));
		
		helpButton.setForeground(Color.white);
		clrButton.setForeground(Color.white);
		helpButton.setBackground(new Color(0,142,194));
		clrButton.setBackground(new Color(190,0,0));
		
		//firstField.setBackground(defaultColor);
		//secondField.setBackground(defaultColor);
		resultField.setBackground(defaultColor);
		resultField.setEditable(false);
		
		firstField.setBorder(BorderFactory.createTitledBorder("Primul polinom"));
		secondField.setBorder(BorderFactory.createTitledBorder("Al doilea polinom"));
		resultField.setBorder(BorderFactory.createTitledBorder("Rezultat"));
		
		firstField.setPreferredSize(fieldDimension);
		secondField.setPreferredSize(fieldDimension);
		resultField.setPreferredSize(fieldDimension);
		
		firstField.setFont(textFieldFont);
		secondField.setFont(textFieldFont);
		resultField.setFont(new Font("",Font.BOLD,20));
			
		operationsPanel.setLayout(new GridLayout(2,4,2,2));
		
		firstPanel.add(firstField);
		secondPanel.add(secondField);
		resultPanel.add(resultField);
		operationsPanel.add(addButton);
		operationsPanel.add(subButton);
		operationsPanel.add(mulButton);
		operationsPanel.add(clrButton);
		operationsPanel.add(divButton);
		operationsPanel.add(intButton);
		operationsPanel.add(derButton);
		operationsPanel.add(helpButton);
		this.add(titleLabel);
		this.add(firstPanel);
		this.add(secondPanel);
		this.add(resultPanel);
		this.add(operationsPanel);

		resultPanel.setVisible(false);
		
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

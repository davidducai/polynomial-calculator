package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.HelpView;

public class HelpController implements ActionListener {

	HelpView view;
	
	HelpController(HelpView view){
		this.view = view;
		
		view.closeButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.dispose();
	}
}

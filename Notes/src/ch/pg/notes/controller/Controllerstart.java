package ch.pg.notes.controller;

import ch.pg.notes.model.Database;
import ch.pg.notes.view.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * @author Patrick
 *
 * 
 */
public class Controllerstart {

	@FXML
	protected TextArea TA;
	
	public void Start() {
		TA.setText(Database.data);
	}
	
	
	@FXML
	protected void New(ActionEvent e) {
		TA.setText("");
		Database.ID = 0;
	}
	
	@FXML
	protected void Restore(ActionEvent e) {
		Start.loadScene("/ch/pg/notes/view/Restore");
//		Controllerrestore CR = new Controllerrestore();
//		CR.Start();
	}

	@FXML
	protected void Save(ActionEvent e) {
		
		System.out.println(Database.ID);
		Database.data = TA.getText();
		if(Database.ID == 0){
			Database.databaseinsert();
		}else {
			Database.databaseupdate();
		}
	}
}

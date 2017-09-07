package ch.pg.notes.controller;

import java.sql.SQLException;

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
	
	Database DB = new Database();
	Start ST = new Start();
	
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
		ST.loadScene("/ch/pg/notes/view/Restore");
//		Controllerrestore CR = new Controllerrestore();
//		CR.start();
	}

	@FXML
	protected void Save(ActionEvent e) throws SQLException {
		Database.data = TA.getText();
		System.out.println(Database.ID);
		System.out.println(Database.data);
		if(Database.ID == 0){
			DB.databaseinsert();
		}else {
			DB.databaseupdate();
		}
	}
	
	@FXML
	protected void refresch(ActionEvent e) {
		System.out.println(Database.data);
		TA.setText(Database.data);
	}
}

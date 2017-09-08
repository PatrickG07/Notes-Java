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
public class Controllerstart implements Runnable{

	@FXML
	protected TextArea TA;
	
	Database DB = new Database();
	Start ST = new Start();
	
	/**
	 * A try to automice
	 */
	@Override
	public void run() {
		System.out.println("hallo");
		start();
	}
	
	/**
	 * Sets the data form the database to the Text Area
	 */
	public void start() {
		TA.setText(Database.data);
	}
	
	/**
	 * Clears the Text Area and Sets the ID to 0 to insert a new data and not Updating the old one
	 * 
	 * @param e
	 */
	@FXML
	protected void newpage(ActionEvent e) {
		TA.setText("");
		Database.ID = 0;
	}
	
	/**
	 * Changes the Scenen to the restor
	 * 
	 * @param e
	 */
	@FXML
	protected void restore(ActionEvent e) {
		ST.loadScene("/ch/pg/notes/view/Restore");
//		Controllerrestore CR = new Controllerrestore();
//		CR.main();
	}

	/**
	 * Saves the Text from the Text Area to the database or updates the database entity with the ID
	 * 
	 * @param e
	 * @throws SQLException
	 */
	@FXML
	protected void save(ActionEvent e) throws SQLException {
		Database.data = TA.getText();
		System.out.println(Database.ID);
		System.out.println(Database.data);
		if(Database.ID == 0){
			DB.databaseinsert();
		}else {
			DB.databaseupdate();
		}
	}
	
	/**
	 * to schow the complet text form the Text Area how came form the database
	 * 
	 * I wont to automace it while Class is loading
	 * 
	 * @param e
	 */
	@FXML
	protected void refresch(ActionEvent e) {
		System.out.println(Database.data);
		TA.setText(Database.data);
	}
}

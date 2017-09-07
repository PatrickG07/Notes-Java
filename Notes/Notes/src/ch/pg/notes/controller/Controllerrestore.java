package ch.pg.notes.controller;

import ch.pg.notes.view.Start;
import ch.pg.notes.model.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Patrick
 *
 *
 */
public class Controllerrestore {

	@FXML
	protected static Button delete;

	Database DB = new Database();
	Start ST = new Start();

	@FXML
	public ListView<String> lvAnzeige;

	public void start() {
		DB.Liste01.clear();
		lvAnzeige.getItems().clear();
		lvAnzeige.getSelectionModel().clearSelection();
		try {
			DB.databaseselect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> Listname2 = DB.Liste01;
		for (String element : Listname2) {
			lvAnzeige.getItems().add(element);
		}
	}

	@FXML
	protected void delete(ActionEvent event) throws SQLException {
		Database.data = lvAnzeige.getSelectionModel().getSelectedItem();
		System.out.println(Database.data);
		DB.databasedelete();
		start();
	}

	@FXML
	protected void back(ActionEvent e) throws SQLException {
		Database.data = lvAnzeige.getSelectionModel().getSelectedItem();
		DB.databaseselectID();
		System.out.println(Database.data);
		System.out.println(Database.ID);
		ST.loadScene("/ch/pg/notes/view/Main");
		// Controllerstart CS = new Controllerstart();
		// CS.Start();
	}
	
	@FXML
	protected void refresch(ActionEvent e) {
		start();
	}
}

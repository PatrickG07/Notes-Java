package ch.pg.notes.controller;

import ch.pg.notes.view.Start;
import ch.pg.notes.model.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.List;

/**
 * @author Patrick
 *
 *
 */
public class Controllerrestore {

	@FXML
	protected static Button delete;

	@FXML
	public ListView<String> lvAnzeige;

	public void Start() {
		Database.Liste01.clear();
		lvAnzeige.getItems().clear();
		lvAnzeige.getSelectionModel().clearSelection();
		Database.databaseselect();
		List<String> Listname2 = Database.Liste01;
		for (String element : Listname2) {
			lvAnzeige.getItems().add(element);
		}
	}

	@FXML
	protected void delete(ActionEvent event) {
		Database.data = lvAnzeige.getSelectionModel().getSelectedItem();
		System.out.println(Database.data);
		Database.databasedelete();
		Start();
	}

	@FXML
	protected void back(ActionEvent e) {
		Database.databaseselectID();
		Database.data = lvAnzeige.getSelectionModel().getSelectedItem();
		Start.loadScene("/ch/pg/notes/view/Main");
//		Controllerstart CS = new Controllerstart();
//		CS.Start();
	}
	
	@FXML
	protected void refresch(ActionEvent e) {
		Start();
	}
}

package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable {

	@FXML private ComboBox<Person> comboBoxPerson;
	@FXML private Button btAll;
	
	private ObservableList<Person> personList;
	
	
	@FXML public void onBtAllAction() {
		for (Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}
	
	@FXML
	public void onComboBoxPersonAction() {
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);
	}
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1, "Alessandro", "Ale@teste.com.br"));
		persons.add(new Person(2, "Maria", "maria@teste.com.br"));
		persons.add(new Person(3, "luige", "luige@teste.com.br"));
		persons.add(new Person(4, "Monica", "Monica@teste.com.br"));
		persons.add(new Person(5, "Laura", "Laura@teste.com.br"));

		personList = FXCollections.observableArrayList(persons);
		comboBoxPerson.setItems(personList);

		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		comboBoxPerson.setCellFactory(factory);
		comboBoxPerson.setButtonCell(factory.call(null));
	}
}

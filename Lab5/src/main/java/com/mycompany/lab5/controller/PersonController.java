package com.mycompany.lab5.controller;

/**
 *
 * @author sriya
 */
import com.mycompany.lab5.model.Person;
import java.util.function.Function;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonController {

    @FXML private TextField nameField;
    @FXML private TextField ageField;
    @FXML private TextField emailField;
    @FXML private Label nameError;
    @FXML private Label ageError;
    @FXML private Label emailError;

    private static final String CSS = "/com/mycompany/lab5/css/style.css";

    @FXML
    private void initialize() {
        // Name: limit to 50 characters
        nameField.textProperty().addListener((obs, o, n) -> {
            if (n.length() > 50) nameField.setText(o);
        });

        // Age: digits only, max 3 characters
        ageField.textProperty().addListener((obs, o, n) -> {
            if (!n.matches("\\d{0,3}")) ageField.setText(o);
        });

        // Email: no spaces allowed
        emailField.textProperty().addListener((obs, o, n) -> {
            if (n.contains(" ")) emailField.setText(o);
        });

        // Live validation when the user leaves a field
        nameField.focusedProperty().addListener((obs, was, now) -> {
            if (!now) check(nameField, nameError, Person::validateName);
        });
        ageField.focusedProperty().addListener((obs, was, now) -> {
            if (!now) check(ageField, ageError, Person::validateAge);
        });
        emailField.focusedProperty().addListener((obs, was, now) -> {
            if (!now) check(emailField, emailError, Person::validateEmail);
        });
    }

    @FXML
    private void handleSubmit() {
        boolean nameOk  = check(nameField, nameError, Person::validateName);
        boolean ageOk   = check(ageField, ageError, Person::validateAge);
        boolean emailOk = check(emailField, emailError, Person::validateEmail);

        if (!(nameOk && ageOk && emailOk)) {
            return; // at least one field is invalid
        }

        Person person = new Person(
                nameField.getText().trim(),
                Integer.parseInt(ageField.getText().trim()),
                emailField.getText().trim());

        showDetailsPopup(person);
    }

    @FXML
    private void handleClear() {
        nameField.clear();
        ageField.clear();
        emailField.clear();
        reset(nameField, nameError);
        reset(ageField, ageError);
        reset(emailField, emailError);
        nameField.requestFocus();
    }

    // ---------- Helpers ----------

    /** Validates one field, updates its UI, returns true if valid. */
    private boolean check(TextField field, Label error, Function<String, String> rule) {
        String msg = rule.apply(field.getText());
        field.getStyleClass().removeAll("invalid", "valid");
        if (msg == null) {
            field.getStyleClass().add("valid");
            error.setText("");
            error.setVisible(false);
            error.setManaged(false);
            return true;
        }
        field.getStyleClass().add("invalid");
        error.setText(msg);
        error.setVisible(true);
        error.setManaged(true);
        return false;
    }

    private void reset(TextField field, Label error) {
        field.getStyleClass().removeAll("invalid", "valid");
        error.setText("");
        error.setVisible(false);
        error.setManaged(false);
    }

    private void showDetailsPopup(Person p) {
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(12);
        grid.setPadding(new Insets(20, 30, 10, 20));

        addRow(grid, 0, "Name",  p.getName());
        addRow(grid, 1, "Age",   String.valueOf(p.getAge()));
        addRow(grid, 2, "Email", p.getEmail());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Submission Successful");
        alert.setHeaderText("Details submitted successfully");
        alert.setGraphic(null);
        alert.getDialogPane().setContent(grid);
        alert.getDialogPane().getStylesheets()
                .add(getClass().getResource(CSS).toExternalForm());
        alert.showAndWait();
    }

    private void addRow(GridPane grid, int row, String key, String value) {
        Label k = new Label(key + ":");
        k.getStyleClass().add("detail-key");
        Label v = new Label(value);
        v.getStyleClass().add("detail-value");
        grid.add(k, 0, row);
        grid.add(v, 1, row);
    }
}
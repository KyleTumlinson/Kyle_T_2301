/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

/*TextArea (JavaFX 8). (2025, October 20).
https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextArea.html
*/

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class TumlinsonGradebookApp extends Application {
    private TextField firstNameText = new TextField();
    private Label firstNameLabel = new Label("First Name: ");
    private TextField lastNameText = new TextField();
    private Label lastNameLabel = new Label("Last Name: ");
    private TextField courseNameText = new TextField();
    private Label courseNameLabel = new Label("Course Name: ");
    private ComboBox<String> courseGradeCombo = new ComboBox<>();
    private Label courseGradeLabel = new Label("Course Grade: ");
    private Button clearButton = new Button("   Clear   ");
    private Button viewGradesButton = new Button("View Grades");
    private Button saveGradeButton = new Button("Save Grade");
    private TextArea gradesTextArea = new TextArea(); // this will show all the grades in a scrollable text area
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // create the options for the combobox and set them to its items.
        ObservableList<String> grades = FXCollections.observableArrayList("A", "B", "C", "D", "F");
        courseGradeCombo.setItems(grades);
        gradesTextArea.setPrefColumnCount(10);
        gradesTextArea.setPrefRowCount(20);
        gradesTextArea.setWrapText(false);
        gradesTextArea.setEditable(false); // do not allow the user to edit the box
        gradesTextArea.setText("Select View Grades To Show Grades.");

        // set the action for when a button is clicked
        clearButton.setOnAction(e->ClearGrade());
        viewGradesButton.setOnAction(e->ViewGrade());
        saveGradeButton.setOnAction(e->SaveGrade());

        // set the coursegrade box to take up the maximum number of slots
        courseGradeCombo.setMaxWidth(Double.MAX_VALUE);

        // setup the new gridpane
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gp.setHgap(5.5);
        gp.setVgap(5.5);

        // add items to the gridpane
        gp.add(firstNameLabel, 0,0);
        gp.add(firstNameText, 1,0);
        gp.add(lastNameLabel, 0,1);
        gp.add(lastNameText, 1,1);
        gp.add(courseNameLabel, 0,2);
        gp.add(courseNameText, 1,2);
        gp.add(courseGradeLabel, 0,3);
        gp.add(courseGradeCombo, 1,3);
        gp.add(gradesTextArea, 0, 4, 2, 1);

        // create an hbox for the buttons
        HBox actionButtons = new HBox();
        actionButtons.setPadding(new Insets(15,0,15,0));
        actionButtons.setSpacing(10);
        actionButtons.getChildren().addAll(clearButton, saveGradeButton, viewGradesButton);

        // add the hbox to the gridpane
        gp.add(actionButtons, 0, 7, 2, 1);

        // create a scene and populate it with the gridpane
        Scene scene = new Scene(gp, 300,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Object ViewGrade() {
        // TODO Get all of the lines from the csv and add them to the textArea
        throw new UnsupportedOperationException("Unimplemented method 'ViewGrade'");
    }

    private Object SaveGrade() {
        // TODO Add the current values to the csv
        throw new UnsupportedOperationException("Unimplemented method 'SaveGrade'");
    }

    private void ClearGrade() {
        // \Clear all of the fields
        firstNameText.setText("");
        lastNameText.setText("");
        courseNameText.setText("");
        courseGradeCombo.setValue(null);
        gradesTextArea.setText("Select View Grades To Show Grades.");
    }
}

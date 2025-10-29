/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.IllegalFormatConversionException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TumlinsonFutureValueApp extends Application
{
    // create the controls and their labels
    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();
    private TextArea txtcalculatedPayments = new TextArea();
    private ComboBox<Integer> yearComboBox = new ComboBox<>();
    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblExample = new Label("Enter11.1% as 11.1");
    private Label lblYears = new Label("Years:");
    private Label lblFutureValueDate = new Label();
    private Button btnCalculate = new Button("Calculate");
    private Button btnClear = new Button("Clear");
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // create the options for the combobox and set them to its items
        ObservableList<Integer> options = FXCollections.observableArrayList(1, 2, 3, 4, 5);
        yearComboBox.setItems(options);
        lblFutureValueDate.setText(setTodaysDate());

        // bind the functions to the buttons that should call them
        btnCalculate.setOnAction(e->calculateResults());
        btnClear.setOnAction(e->clearFormFields());
        
        // force the combobox to take up the highest amount of space it can, otherwise it only takes up 1 column
        yearComboBox.setMaxWidth(Double.MAX_VALUE);
        
        // create the gridpane that all the user entries will go to
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gp.setHgap(5.5);
        gp.setVgap(5.5);

        // add the user controls to the gridpane
        gp.add(lblMonthlyPayment, 0, 0);
        gp.add(txtMonthlyPayment, 1, 0);
        gp.add(lblInterestRate, 0,1);
        gp.add(txtInterestRate, 1, 1);
        gp.add(lblExample, 1, 2);
        gp.add(lblYears, 0,3);
        gp.add(yearComboBox, 1,3, 2, 1);
        
        // make adjustments to the label and its alignment on the gridpane
        lblExample.setTextFill(Color.RED);
        GridPane.setHalignment(lblExample, HPos.RIGHT);
        
        // add an HBox for the buttons
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15,0,15,30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().addAll(btnClear,btnCalculate);

        // add the HBox to the gridPane
        gp.add(actionBtnContainer, 1,4);
        gp.add(lblFutureValueDate, 0,5, 2, 1);
        gp.add(txtcalculatedPayments, 0,6, 2,1);

        // create the scene and add to the stage, using the gridpane as the root
        Scene scene = new Scene(gp, 300, 400);
        primaryStage.setTitle("Tumlinson Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // clear all fields in the form
    private void clearFormFields()
    {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        txtcalculatedPayments.setText("");
        yearComboBox.setValue(null);
        lblFutureValueDate.setText(setTodaysDate());
    }

    // calculate the results from calculateFutureValue and set the text for calculatedPayaments
    private void calculateResults()
    {
        try
        {
            String mnthtxt = txtMonthlyPayment.getText();
            double mnthPay = Double.parseDouble(mnthtxt);
            String inttxt = txtInterestRate.getText();
            double intRate = Double.parseDouble(inttxt);
            Integer years = yearComboBox.getValue();
            System.out.println();
            txtcalculatedPayments.setText(String.format("The future value is  $%,6.2f", FinanceCalculator.calculateFutureValue(mnthPay, intRate, years)));
        }
        catch (NumberFormatException e)
        {
            txtcalculatedPayments.setText("Invalid input.");
        }
        catch (IllegalFormatConversionException e)
        {
            txtcalculatedPayments.setText("Invalid input.");
        }
    }

    private String setTodaysDate()
    {
        LocalDate todaysDate = LocalDate.now();
        DateTimeFormatter todaysDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String todayString = todaysDate.format(todaysDateFormat);
        return String.format("Calculation as of %s", todayString);
    }
}

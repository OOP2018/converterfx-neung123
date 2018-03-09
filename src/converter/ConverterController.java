package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *  UI controller for events and initializing components.
 */
public class ConverterController {
    @FXML
    TextField textfield1;
    @FXML
    TextField textfield2;
    @FXML
    ComboBox<Length> comboBox1;
    @FXML
    ComboBox<Length> comboBox2;


    /**
     * JavaFX calls the initialize() method of your controller when
     * it creates the UI form, after the components have been created
     * and @FXML annotated attributes have been set.
     *
     * This is a hook to initialize anything your controller or UI needs.
     */
    @FXML
    public void initialize() {
        if (comboBox1 != null) {
            comboBox1.getItems().addAll( Length.values() );
            comboBox1.getSelectionModel().select(0); // select an item to show
        }
        if (comboBox2 != null) {
            comboBox2.getItems().addAll( Length.values() );
            comboBox2.getSelectionModel().select(1); // select an item to show
        }
    }

    public void handleConvert(ActionEvent event) {

        String text1 = textfield1.getText().trim();
        String text2 = textfield2.getText().trim();

        Length unit1 = comboBox1.getValue();
        Length unit2 = comboBox2.getValue();

        if(text2.isEmpty()){
            convert(text1,textfield2,unit1,unit2);
        }else if(text1.isEmpty()){
            convert(text2,textfield1,unit2,unit1);
        }


    }

    public void handleClear(ActionEvent event) {
        textfield1.setText("");
        textfield2.setText("");
        textfield1.setStyle("-fx-text-inner-color: black;");
        textfield2.setStyle("-fx-text-inner-color: black;");
    }

    public void convert(String input,TextField textField,Length unit1,Length unit2){

        double inputNum = 0;
        try {
            inputNum = Double.parseDouble(input);
        }catch (NumberFormatException e){
            textField.setText("Invalid Input");
            textField.setStyle("-fx-text-inner-color: red;");
            return;
        }

        double toMeter = inputNum*unit1.getValue();

        double result = toMeter/unit2.getValue();

        textField.setText(String.format("%.4f",result));
    }

}

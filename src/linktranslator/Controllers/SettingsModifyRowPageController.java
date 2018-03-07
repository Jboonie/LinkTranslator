/*
 * The MIT License
 *
 * Copyright 2018 Jacob Boone.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package linktranslator.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import linktranslator.DataStructures.PropertyPair;
import linktranslator.Logic.PropertiesController;

/**
 * FXML Controller class
 *
 * @author Jacob Boone
 */
public class SettingsModifyRowPageController implements Initializable {

    private PropertiesController DATA_CONTROLLER;
    private PropertiesController SETTINGS_CONTROLLER;
    private SettingsPageController PARRENT_CONTROLLER;
    private PropertyPair TARGET_PAIR;
    
    @FXML 
    private TextField leftTextField;
    @FXML 
    private TextField rightTextField;
    
    @FXML
    public void add(ActionEvent event){
        PropertyPair newPair = new PropertyPair(leftTextField.getText(), rightTextField.getText());
        DATA_CONTROLLER.add(newPair);
        DATA_CONTROLLER.remove(TARGET_PAIR);
        PARRENT_CONTROLLER.drawDataTable();
        TARGET_PAIR = newPair;
    }
    
    @FXML
    public void cancel(ActionEvent event){
        Stage window = (Stage) leftTextField.getScene().getWindow();
        window.close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    void loadDataController(PropertiesController DATA_CONTROLLER) {
        this.DATA_CONTROLLER = DATA_CONTROLLER;
    }

    void loadSettingsController(PropertiesController SETTINGS_CONTROLLER) {
        this.SETTINGS_CONTROLLER = SETTINGS_CONTROLLER;
    }

    void loadParrentController(SettingsPageController PARRENT_CONTROLLER) {
        this.PARRENT_CONTROLLER = PARRENT_CONTROLLER;
    }
    
    void loadTargetPair(PropertyPair TARGET_PAIR){
        this.TARGET_PAIR = TARGET_PAIR;
        leftTextField.setText(TARGET_PAIR.getKey());
        rightTextField.setText(TARGET_PAIR.getValue());
    }
    
}

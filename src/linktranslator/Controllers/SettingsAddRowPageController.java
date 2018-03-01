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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import linktranslator.DataStructures.PropertyPair;
import linktranslator.Logic.PropertiesController;

/**
 * FXML Controller class
 *
 * @author Jacob Boone
 */
public class SettingsAddRowPageController implements Initializable {

    private PropertiesController DATA_CONTROLLER;
    private PropertiesController SETTINGS_CONTROLLER;
    private SettingsPageController PARRENT_CONTROLLER;
    
    @FXML
    private Label leftComparisonLabel;
    @FXML
    private TextField leftComparisonTextField;
    @FXML
    private Label rightComparisonLabel;
    @FXML
    private TextField rightComparisonTextField;
    
    @FXML
    public void add(ActionEvent event){
        String left = leftComparisonTextField.getText();
        String right = rightComparisonTextField.getText();
        
        PropertyPair pair = new PropertyPair(left, right);
        
        DATA_CONTROLLER.add(pair);
        
        leftComparisonTextField.setText("");
        rightComparisonTextField.setText("");
        
        PARRENT_CONTROLLER.drawDataTable();
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
    
    public void loadParrentController(SettingsPageController PARRENT_CONTROLLER){
        this.PARRENT_CONTROLLER = PARRENT_CONTROLLER;
    }
    
}

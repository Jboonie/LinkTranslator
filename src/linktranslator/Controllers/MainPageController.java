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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import linktranslator.DataStructures.PropertyPair;
import linktranslator.Logic.PropertiesController;
import linktranslator.StaticData.Paths;
import linktranslator.StaticData.Strings;

/**
 *
 * @author Jacob Boone
 */
public class MainPageController implements Initializable {
    
    private PropertiesController DATA_CONTROLLER;
    private PropertiesController SETTINGS_CONTROLLER;
    private ResourceBundle activeLanguage;
    private boolean togglePointedLeft = false;
    
    @FXML
    private Label leftToggleLabel;
    @FXML
    private Label rightToggleLabel;
    @FXML
    private Button toggleButton;
    @FXML
    private TextArea textArea;
    
    //BUTTON BEHAVIOR
    @FXML
    private void showSettingsPage(ActionEvent event){

        try {
            FXMLLoader loadedFXML = new FXMLLoader(getClass().getResource(Paths.FXML_SETTINGS_PAGE), activeLanguage);
            
            Parent root = loadedFXML.load();
            
            SettingsPageController controller = loadedFXML.<SettingsPageController>getController(); 
            controller.loadDataController(DATA_CONTROLLER);
            controller.loadSettingsController(SETTINGS_CONTROLLER);
            controller.loadThisController(controller);
            
            Stage newStage = new Stage(); 
            Scene scene = new Scene(root);
            newStage.setScene(scene);
//            newStage.getIcons().add(Paths.IMAGE_BIRD);
            newStage.setTitle(Strings.PAGE_TITLE_SETTINGS);
            newStage.show();
            controller.drawDataTable();
        } catch (IOException ex) {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void showAboutPage(ActionEvent event){
        try {
            FXMLLoader loadedFXML = new FXMLLoader(getClass().getResource(Paths.FXML_ABOUT_PAGE), activeLanguage);

            Parent root = loadedFXML.load();
            Stage newStage = new Stage(); 
            Scene scene = new Scene(root);
            newStage.setScene(scene);
//            newStage.getIcons().add(Paths.IMAGE_BIRD);
            newStage.setTitle(Strings.PAGE_TITLE_ABOUT);
            newStage.show();
        } catch (IOException ex) {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void showHowToPage(ActionEvent event){
        try {
            FXMLLoader loadedFXML = new FXMLLoader(getClass().getResource(Paths.FXML_HOWTO_PAGE), activeLanguage);
            Parent root = loadedFXML.load();
            Stage newStage = new Stage(); 
            Scene scene = new Scene(root);

            newStage.setScene(scene);
//            newStage.getIcons().add(Paths.IMAGE_BIRD);
            newStage.setTitle(Strings.PAGE_TITLE_HOWTO);
            newStage.show();
        } catch (IOException ex) {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void convertButton(ActionEvent event){
        ArrayList<PropertyPair> pairs = DATA_CONTROLLER.getPairs();
         
        String text = textArea.getText();
        
        if(togglePointedLeft){
            for(PropertyPair pair : pairs){
               text = text.replace(pair.getValue(), pair.getKey());
            }   
        }
        else{
            for(PropertyPair pair : pairs){
               text = text.replace(pair.getKey(), pair.getValue());
            }
        }
        textArea.setText(text);
    }
    
    @FXML
    private void toggleButton(ActionEvent event){
        buttonToggle();
    }

    //END BUTTON BEHAVIOR
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        activeLanguage = Paths.ENG_BUNDLE;
        buttonToggle();
    }
        
    public void loadDataController(PropertiesController dataController){
        DATA_CONTROLLER = dataController;
    }
    
    public void loadSettingsController(PropertiesController settingsController){
        SETTINGS_CONTROLLER = settingsController;
    }    
    
    public void buttonToggle(){
        if(togglePointedLeft){
            leftToggleLabel.setVisible(false);
            rightToggleLabel.setVisible(true);
            togglePointedLeft = false;
            toggleButton.setText("->");
        }
        else{
            leftToggleLabel.setVisible(true);
            rightToggleLabel.setVisible(false);
            togglePointedLeft = true;
            toggleButton.setText("<-");
        }
    }
    
    public void loadToggleLabels(){
        leftToggleLabel.setText(SETTINGS_CONTROLLER.get(Strings.SETTINGS_KEY_LEFT_COLUMN, "Key").getValue());
        rightToggleLabel.setText(SETTINGS_CONTROLLER.get(Strings.SETTINGS_KEY_RIGHT_COLUMN, "Value").getValue());
    }
}

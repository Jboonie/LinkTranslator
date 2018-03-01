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

import com.sun.javafx.scene.control.skin.TableViewSkin;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import linktranslator.DataStructures.PropertyPair;
import linktranslator.Logic.PropertiesController;
import linktranslator.StaticData.Paths;
import linktranslator.StaticData.Strings;

/**
 * FXML Controller class
 *
 * @author Jacob Boone
 */
public class SettingsPageController implements Initializable {

    private PropertiesController DATA_CONTROLLER;
    private boolean DATA_LOADED = false;
    private PropertiesController SETTINGS_CONTROLLER;
    private boolean SETTINGS_LOADED = false;
    private ResourceBundle activeLanguage;
    private boolean wasFocused = true;
    private SettingsPageController THIS_CONTROLLER;
    private String LEFT_COLUMN_NAME;
    private String RIGHT_COLUMN_NAME;
    
    private ObservableList<PropertyPair> TABLE_DATA = FXCollections.observableArrayList();
    
    @FXML 
    private TableView<PropertyPair> table;
    
    @FXML
    private AnchorPane anchor;
    
    //BUTTON BEHAVIOR
    @FXML
    private void showModifyColumnsPage(ActionEvent event){
        try {
            FXMLLoader loadedFXML = new FXMLLoader(getClass().getResource(Paths.FXML_SETTINGS_MODIFY_COLUMN_PAGE), activeLanguage);
            Parent root = loadedFXML.load();
            
            SettingsModifyColumnsPageController controller = loadedFXML.<SettingsModifyColumnsPageController>getController();
            controller.loadDataController(DATA_CONTROLLER);
            controller.loadSettingsController(SETTINGS_CONTROLLER);
            controller.loadParrentController(THIS_CONTROLLER);
            
            Stage newStage = new Stage(); 
            Scene scene = new Scene(root);
            newStage.setScene(scene);
//            newStage.getIcons().add(Paths.IMAGE_BIRD);
            newStage.setTitle(Strings.PAGE_TITLE_SETTINGS_MODIFY_COLUMNS);
            newStage.show();
            controller.populateModify();
        } catch (IOException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void showModifyRowPage(ActionEvent event){
        if(table.getSelectionModel().getSelectedItem() != null){
            PropertyPair pairToModify = table.getSelectionModel().getSelectedItem();
            try {
                FXMLLoader loadedFXML = new FXMLLoader(getClass().getResource(Paths.FXML_SETTINGS_MODIFY_ROW_PAGE), activeLanguage);
                Parent root = loadedFXML.load();

                SettingsModifyRowPageController controller = loadedFXML.<SettingsModifyRowPageController>getController();
                controller.loadDataController(DATA_CONTROLLER);
                controller.loadSettingsController(SETTINGS_CONTROLLER);
                controller.loadParrentController(THIS_CONTROLLER);

                Stage newStage = new Stage(); 
                Scene scene = new Scene(root);
                newStage.setScene(scene);
    //            newStage.getIcons().add(Paths.IMAGE_BIRD);
                newStage.setTitle(Strings.PAGE_TITLE_SETTINGS_MODIFY_ROW);
                newStage.show();
                controller.loadTargetPair(pairToModify);
            } catch (IOException ex) {
                Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void showAddRowPage(ActionEvent event){
        try {
            FXMLLoader loadedFXML = new FXMLLoader(getClass().getResource(Paths.FXML_SETTINGS_ADD_ROW_PAGE), activeLanguage);
            
            Parent root = loadedFXML.load();
            
            SettingsAddRowPageController controller = loadedFXML.<SettingsAddRowPageController>getController();
            controller.loadDataController(DATA_CONTROLLER);
            controller.loadSettingsController(SETTINGS_CONTROLLER);
            controller.loadParrentController(THIS_CONTROLLER);
            
            Stage newStage = new Stage(); 
            Scene scene = new Scene(root);
            
            newStage.setScene(scene);
//            newStage.getIcons().add(Paths.IMAGE_BIRD);
            newStage.setTitle(Strings.PAGE_TITLE_SETTINGS_ADD_ROW);
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void deleteRow(ActionEvent event){
        PropertyPair target = table.getSelectionModel().getSelectedItem();
        DATA_CONTROLLER.remove(target);
        drawDataTable();
    }
    
    @FXML
    private void gainedFocus(MouseEvent event){
        drawDataTable();
    }
    //END BUTTON BEHAVIOR
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        activeLanguage = Paths.ENG_BUNDLE;
    }

    public void drawDataTable(){
        LEFT_COLUMN_NAME = SETTINGS_CONTROLLER.get(Strings.SETTINGS_KEY_LEFT_COLUMN, "Key").getValue();
        RIGHT_COLUMN_NAME = SETTINGS_CONTROLLER.get(Strings.SETTINGS_KEY_RIGHT_COLUMN, "Value").getValue();
        
        
        table.getColumns().clear();
        TABLE_DATA = FXCollections.observableArrayList();

        for(PropertyPair pair : DATA_CONTROLLER.getPairs()){
            TABLE_DATA.add(pair);
        }
        
        table.setEditable(false);
        
        
        TableColumn keyColumn = new TableColumn(LEFT_COLUMN_NAME);        
        keyColumn.setCellValueFactory(new PropertyValueFactory<PropertyPair, String>("key"));
        

        TableColumn valueColumn = new TableColumn(RIGHT_COLUMN_NAME);        
        valueColumn.setCellValueFactory(new PropertyValueFactory<PropertyPair, String>("value"));

        keyColumn.prefWidthProperty().bind(table.widthProperty().divide(2));
        valueColumn.prefWidthProperty().bind(table.widthProperty().divide(2));
        
        table.setItems(TABLE_DATA);
        table.getColumns().clear();
        table.getColumns().addAll(keyColumn, valueColumn);
    }

    public void loadDataController(PropertiesController DATA_CONTROLLER) {
        this.DATA_CONTROLLER = DATA_CONTROLLER;
        DATA_LOADED = true;
    }

    public void loadSettingsController(PropertiesController SETTINGS_CONTROLLER) {
        this.SETTINGS_CONTROLLER = SETTINGS_CONTROLLER;
        SETTINGS_LOADED = true;
    }
    
    public void loadThisController(SettingsPageController THIS_CONTROLLER){
        this.THIS_CONTROLLER = THIS_CONTROLLER;
    }
    
    public void modifyRow(PropertyPair pair){
        DATA_CONTROLLER.remove(pair);
        drawDataTable();
    }
}

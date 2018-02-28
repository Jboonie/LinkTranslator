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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import linktranslator.StaticData.Paths;
import linktranslator.StaticData.Strings;

/**
 * FXML Controller class
 *
 * @author Jacob Boone
 */
public class SettingsPageController implements Initializable {

    private ResourceBundle activeLanguage;
    
    //BUTTON BEHAVIOR
    @FXML
    private void showModifyColumnsPage(ActionEvent event){
        pageLaunch(Paths.FXML_SETTINGS_MODIFY_COLUMN_PAGE, activeLanguage, Strings.PAGE_TITLE_SETTINGS_MODIFY_COLUMNS);
    }
    
    @FXML
    private void showModifyRowPage(ActionEvent event){
        pageLaunch(Paths.FXML_SETTINGS_MODIFY_ROW_PAGE, activeLanguage, Strings.PAGE_TITLE_SETTINGS_MODIFY_ROW);
    }
    
    @FXML
    private void showAddRowPage(ActionEvent event){
        pageLaunch(Paths.FXML_SETTINGS_ADD_ROW_PAGE, activeLanguage, Strings.PAGE_TITLE_SETTINGS_ADD_ROW);
    }
    //END BUTTON BEHAVIOR
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        activeLanguage = Paths.ENG_BUNDLE;
    }    
    
    private void pageLaunch(String fxmlLocation, ResourceBundle bundle, String pageTitle){
        try {
            FXMLLoader loadedFXML = new FXMLLoader(getClass().getResource(fxmlLocation), bundle);
            Parent root = loadedFXML.load();
            Stage newStage = new Stage(); 
            Scene scene = new Scene(root);
            
            newStage.setScene(scene);
//            newStage.getIcons().add(Paths.IMAGE_BIRD);
            newStage.setTitle(pageTitle);
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

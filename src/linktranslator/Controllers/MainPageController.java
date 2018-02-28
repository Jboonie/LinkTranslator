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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import linktranslator.StaticData.Paths;
import linktranslator.StaticData.Strings;

/**
 *
 * @author Jacob Boone
 */
public class MainPageController implements Initializable {
    
    private ResourceBundle activeLanguage;
    
    //BUTTON BEHAVIOR
    @FXML
    private void showSettingsPage(ActionEvent event){
        pageLaunch(Paths.FXML_SETTINGS_PAGE, activeLanguage, Strings.PAGE_TITLE_SETTINGS);
    }
    
    @FXML
    private void showAboutPage(ActionEvent event){
        pageLaunch(Paths.FXML_ABOUT_PAGE, activeLanguage, Strings.PAGE_TITLE_ABOUT);
    }
    
    @FXML
    private void showHowToPage(ActionEvent event){
            pageLaunch(Paths.FXML_HOWTO_PAGE, activeLanguage, Strings.PAGE_TITLE_HOWTO);
    }
    

    //END BUTTON BEHAVIOR
    
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

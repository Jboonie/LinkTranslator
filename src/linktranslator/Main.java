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
package linktranslator;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import linktranslator.Controllers.MainPageController;
import linktranslator.Logic.PropertiesController;
import linktranslator.StaticData.Paths;
import linktranslator.StaticData.Strings;

/**
 *
 * @author Jacob Boone
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader MainPageLoader = new FXMLLoader(getClass().getResource(Paths.FXML_MAIN_PAGE), Paths.ENG_BUNDLE);
        
        PropertiesController DATA_CONTROLLER = new PropertiesController(new File(Paths.SETTINGS_DATA_SETTINGS));        
        PropertiesController SETTINGS_CONTROLLER = new PropertiesController(new File(Paths.SETTINGS_APP_SETTINGS));
        
        
        Parent root = MainPageLoader.load();
        
        MainPageController controller = MainPageLoader.<MainPageController>getController();
        controller.loadDataController(DATA_CONTROLLER);
        controller.loadSettingsController(SETTINGS_CONTROLLER);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(Strings.PAGE_TITLE_MAIN);
        stage.getIcons().add(Paths.IMAGE_LINKS);
        stage.show();
        controller.loadToggleLabels();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

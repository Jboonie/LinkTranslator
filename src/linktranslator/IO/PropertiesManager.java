/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linktranslator.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob Boone
 */
public class PropertiesManager {
    private File PROPERTIES_FILE;

    public PropertiesManager(File propertyFile) {
        try {
            File parentDirectory = propertyFile.getParentFile();
            parentDirectory.mkdir();
            propertyFile.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        PROPERTIES_FILE = propertyFile;
    }
    
    public Properties readProperties(){
        Properties returnProperties = new Properties();
        try {
            InputStream read = new FileInputStream(PROPERTIES_FILE);
            returnProperties.loadFromXML(read);
            read.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnProperties;
    }

    public void writeProperties(Properties properties){
        try{
            OutputStream write = new FileOutputStream(PROPERTIES_FILE);
            properties.storeToXML(write, "");
            write.close();
        }catch(IOException e){
        }
    }
}

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
package linktranslator.Logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import linktranslator.DataStructures.PropertyPair;
import linktranslator.IO.PropertiesManager;

/**
 *
 * @author Jacob Boone
 */
public class PropertiesController {

    private File PROPERTIES_FILE;
    private Properties PROPERTIES;
    private PropertiesManager PROPERTY_MANAGER;
    private ArrayList<PropertyPair> PROPERTY_PAIRS;
    
    public PropertiesController(File targetFile) {
        PROPERTIES_FILE = targetFile;
        PROPERTY_MANAGER = new PropertiesManager(PROPERTIES_FILE);
        PROPERTIES = PROPERTY_MANAGER.readProperties();
        maintainIntegrity();
        updatePairs();
    }
    
    public void add(PropertyPair pair){
        PROPERTIES.setProperty(pair.getKey(), pair.getValue());
        maintainIntegrity();
        PROPERTY_MANAGER.writeProperties(PROPERTIES);
        updatePairs();
    }
    
    public void remove(PropertyPair pair){
        PROPERTIES.remove(pair.getKey());
        PROPERTY_MANAGER.writeProperties(PROPERTIES);
        updatePairs();
    }
    
    public ArrayList<PropertyPair> getPairs(){
        maintainIntegrity();
        PROPERTY_MANAGER.writeProperties(PROPERTIES);
        updatePairs();
        return PROPERTY_PAIRS;
    }
    
    private void updatePairs(){
    PROPERTY_PAIRS = new ArrayList<>();
    Enumeration keys = PROPERTIES.keys();

        while(keys.hasMoreElements()){
            String key = (String) keys.nextElement();
            PROPERTY_PAIRS.add(new PropertyPair(key, PROPERTIES.getProperty(key)));
        }
    }
    
    private void maintainIntegrity(){
        Enumeration values = PROPERTIES.elements();
        Enumeration keys = PROPERTIES.keys();
        
        while (keys.hasMoreElements()){
            String key = (String) keys.nextElement();
            
            while(values.hasMoreElements()){
                String value = (String) values.nextElement();
                if(key.equals(value)){
                    PROPERTIES.remove(key);
                }
            }        
        }
    }
}

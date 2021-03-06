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
package linktranslator.DataStructures;

import java.util.ResourceBundle;

/**
 *
 * @author Jacob Boone
 */
public class SupportedLanguage {
    
    private String NAME;
    private ResourceBundle BUNDLE;

    public SupportedLanguage(String NAME, ResourceBundle BUNDLE) {
        this.NAME = NAME;
        this.BUNDLE = BUNDLE;
    }

    public ResourceBundle getBUNDLE() {
        return BUNDLE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setBUNDLE(ResourceBundle BUNDLE) {
        this.BUNDLE = BUNDLE;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
}

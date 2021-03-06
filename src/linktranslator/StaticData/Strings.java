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
package linktranslator.StaticData;

/**
 *
 * @author Jacob Boone
 */
public class Strings {

    private static final String VERSION = "0.2";
    private static final String APPNAME = "Link Translator";
    private static final String TITLEBAR = APPNAME + " " + VERSION;
    public static final String PAGE_TITLE_MAIN = TITLEBAR;
    public static final String PAGE_TITLE_SETTINGS = TITLEBAR + " - Settings";
    public static final String PAGE_TITLE_ABOUT = TITLEBAR + " - About";
    public static final String PAGE_TITLE_HOWTO = TITLEBAR + " - How To";
    public static final String PAGE_TITLE_SETTINGS_MODIFY_COLUMNS = TITLEBAR + " - Modify Columns";
    public static final String PAGE_TITLE_SETTINGS_MODIFY_ROW = TITLEBAR + " - Modify Row";
    public static final String PAGE_TITLE_SETTINGS_ADD_ROW = TITLEBAR + " - Add Row";
    
    public static final String SETTINGS_KEY_LEFT_COLUMN = "LEFT_COLUMN";
    public static final String SETTINGS_KEY_RIGHT_COLUMN = "RIGHT_COLUMN";
    
    //PROJECT URL(S) & HELP FILE URL(S)
    public static String PROJECT_WEBSITE_URL = "https://github.com/Jboonie/LinkTranslator";

    public Strings() {
    }    
}

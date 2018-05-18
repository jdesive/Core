/*
 * Copyright (C) 2017  Jack DeSive
 *
 * This file is part of Core.
 *
 * Core is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.desive.fxutils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URI;

/*
 Created by Jack DeSive on 12/2/2017 at 12:19 AM
*/
public class Utils extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

       URI uri = new URI("https://www.google.com/");
       String content = "<!DOCTYPE html>\n" +
               "<html>\n" +
               "<head><style>a {\n" +
               "    background-color: #3B3F42;\n" +
               "    font-family: 'Courier Primal', 'Courier Regular', monospace;\n" +
               "    color: #90b8e0;\n" +
               "    text-decoration: none;\n" +
               "}\n" +
               "a:hover {\n" +
               "    text-decoration: underline;\n" +
               "}\n" +
               "blockquote {\n" +
               "    padding: 1px;\n" +
               "    background-color: #545454;\n" +
               "}\n" +
               "body {\n" +
               "    background-color: #3B3F42;\n" +
               "    font-family: 'Courier Primal', 'Courier Regular', monospace;\n" +
               "    color: #f8f8f2;\n" +
               "}\n" +
               "p code, li code {\n" +
               "    background-color: rgba(44, 44, 44, 0.4);\n" +
               "    padding: 0px 3px 0px 3px;\n" +
               "    border-radius: 2px;\n" +
               "}\n" +
               "pre {\n" +
               "    background-color: #545454;\n" +
               "}\n" +
               "pre, table {\n" +
               "    overflow: scroll;\n" +
               "    padding: 10px;\n" +
               "}\n" +
               "pre, table, blockquote {\n" +
               "    font-family: 'Courier Primal', 'Courier Regular', monospace;\n" +
               "    color: #f8f8f2;\n" +
               "    border-radius: 2px;\n" +
               "    width: 97%;\n" +
               "}\n" +
               "table {\n" +
               "    background-color: #545454;\n" +
               "}\n" +
               "img {\n" +
               "    max-width: 100%;\n" +
               "    height: auto;\n" +
               "    width: auto\\9; /* ie8 */\n" +
               "}</style></head><body><h1 id=\"textmd-sample\"><a href=\"#textmd-sample\" id=\"textmd-sample\" name=\"textmd-sample\" class=\"anchor\"><span class=\"octicon octicon-link\"></span>TextMd Sample</a></h1>\n" +
               "<h2 id=\"some-samples\"><a href=\"#some-samples\" id=\"some-samples\" name=\"some-samples\" class=\"anchor\"><span class=\"octicon octicon-link\"></span>Some samples</a></h2>\n" +
               "<p><strong>BOLD</strong> Text<br>\n" +
               "<em>ITALIC</em> Text<br>\n" +
               "<strong>BOLD</strong> Text<br>\n" +
               "<em>ITALIC</em> Text<br>\n" +
               "<code>inline-code</code> Text<br>\n" +
               "<del>Strikethrough</del> Text<br>\n" +
               "<a href=\"https://github.com\">Link</a> Hyperlink<br>\n" +
               "<img src=\"http://via.placeholder.com/50x50\" alt=\"Alt Text\"> Image</p>\n" +
               "<h2 id=\"code\"><a href=\"#code\" id=\"code\" name=\"code\" class=\"anchor\"><span class=\"octicon octicon-link\"></span>Code</a></h2>\n" +
               "<pre><code class=\"prettyprint lang-java\">public static String sample = \"Here is some sample Java code!\";\n" +
               "</code></pre>\n" +
               "<p>Much more!</p>\n" +
               "<hr>\n" +
               "</body>\n" +
               "</html>";

        Scene scene = new Scene(new StaticWebView(content), 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

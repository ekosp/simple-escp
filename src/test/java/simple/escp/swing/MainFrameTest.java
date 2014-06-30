/*
 * Copyright 2014 Jocki Hendry
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package simple.escp.swing;

import simple.escp.Template;
import simple.escp.json.JsonTemplate;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrameTest extends JFrame {

    public MainFrameTest() {
        super("Preview");

        Template template = new JsonTemplate(
        "{" +
            "\"pageFormat\": {" +
                "\"pageWidth\": \"30\"," +
                "\"pageLength\": \"10\"" +
            "}," +
            "\"placeholder\": [" +
                "\"id\"," +
                "\"nickname\"" +
            "]," +
            "\"template\": [" +
                "\"User Report\"," +
                "\"===========\"," +
                "\"ID   : ${id}\"," +
                "\"Name : ${nickname}\"" +
            "]" +
        "}");
        Map<String, String> value = new HashMap<>();
        value.put("id", "007");
        value.put("nickname", "The Solid Snake");

        PrintPreviewPane printPreview = new PrintPreviewPane(template, value);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(printPreview, BorderLayout.CENTER);

        setPreferredSize(new Dimension(500, 500));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main (String[] args) {
        new MainFrameTest();
    }

}

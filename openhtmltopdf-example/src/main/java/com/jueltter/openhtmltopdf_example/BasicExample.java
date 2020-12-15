/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jueltter.openhtmltopdf_example;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Stalin
 */
public class BasicExample {

    public static void main(String args[]) throws Exception {

        URL url = BasicExample.class.getResource("/index.html");
        
        File file = new File(url.toURI());
        String data = FileUtils.readFileToString(file, "UTF-8");
        System.out.println(data);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withHtmlContent(data, BasicExample.class.getResource("/root.htm").toExternalForm());
        builder.useFastMode();
        builder.toStream(os);
        builder.run();

        try (FileOutputStream fos = new FileOutputStream("E:\\index.pdf")) {
            fos.write(os.toByteArray());
        }
    }

}

package com.itschool.springapp;

import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.text.Document;
import java.awt.*;

@SpringBootApplication
public class SpringappApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringappApplication.class, args);
        try (PDDocument pdfDocument = new PDDocument()) {
            PDPage page1 = new PDPage();
            pdfDocument.addPage(page1);
            PDPageContentStream contentStreamP1 = new PDPageContentStream(pdfDocument, page1);
            contentStreamP1.beginText();
            String text = "Salut, ma numesc Laurentiu Nabarogu!";
            contentStreamP1.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 14);
            contentStreamP1.newLineAtOffset(200, 500);
            contentStreamP1.showText(text);
            contentStreamP1.endText();
            contentStreamP1.close();
            pdfDocument.save("myFirstPdfFromJava.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

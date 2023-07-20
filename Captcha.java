package de.zeroco.utility;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import de.zeroco.javabean.GetCaptcha;

public class Captcha {

    public static void main(String[] args) {
		String text = GetCaptcha.getCaptcha();
		String filePath = "C:\\Users\\91834\\Desktop\\Sample\\output.png";
		int imageWidth = 400;
		int imageHeight = 400;
		int textSize = 50;
		String imageType = "png";
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames = ge.getAvailableFontFamilyNames();
		System.out.println(convertTextIntoImage(text, filePath, imageWidth, imageHeight, textSize, fontNames, imageType));
    }
    
    public static String convertTextIntoImage(String text, String filePath, int imageWidth, int imageHeight, int textSize, String[] fontNames, String imageType) {
        if (text == null || text.isEmpty() || filePath == null || filePath.isEmpty() || imageWidth <= 0 || imageHeight <= 0 || textSize <= 0 || fontNames == null || fontNames.length == 0 || imageType == null || imageType.isEmpty()) {
            return null;
        }
        BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        int textWidth = graphics.getFontMetrics().stringWidth(text);
        int textHeight = graphics.getFontMetrics().getHeight();
        int width = (imageWidth - textWidth) / 2;
        int height = (imageHeight - textHeight) / 2 + graphics.getFontMetrics().getAscent();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            String fontName = fontNames[new Random().nextInt(fontNames.length - 1)];
            Font font = new Font(fontName, Font.PLAIN, textSize);
            graphics.setFont(font);
            graphics.setColor(Color.BLACK);
            graphics.drawString(String.valueOf(c), width, height);
            width = width + graphics.getFontMetrics().charWidth(c);
        }
        try {
            ImageIO.write(image, imageType, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}


package labs.lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent {
    /** Экземпляр класса Jcomponent
     * Обрабатывает изображение, которое генерирует код**/
    private BufferedImage image;

    public JImageDisplay (int width, int height){
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        /*Инициализация экземпляра и вызов метода родительского класса*/
        Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension);
    }

    /**Блок кода, предназначенный для рисования изображения**/
    public void paintComponent(Graphics g){
        /*Вызов метода родительского класса, чтобы изображение было нарисовано правильно*/
        super.paintComponent(g);
        g.drawImage (image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

    /**
     Метод, предназначенный для очистки изображения (устанавливает черный цвет всех пикселей)**/
    public void clearImage(){
        int size = getWidth() * getHeight();
        int[] pixels = new int[size];
        image.setRGB(0, 0, getWidth(), getHeight(), pixels, 0, 1);
    }

    /**Устанавливает для пикселя собственный цвет**/
    public void drawPixel(int x, int y, int color){
        image.setRGB(x, y, color);
    }
}
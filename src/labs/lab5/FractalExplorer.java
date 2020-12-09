package labs.lab5;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.awt.image.*;

public class FractalExplorer {
    private int displaySize;
    private JImageDisplay display;
    private FractalGenerator fractal;
    private Rectangle2D.Double range;
    public FractalExplorer(int size) {
        displaySize = size;
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);

    }
    public void createAndShowGUI() {
        display.setLayout(new BorderLayout());
        JFrame myFrame = new JFrame("Проверка фракталов");
        myFrame.add(display, BorderLayout.CENTER);
        /*Создание кнопки обновления*/
        JButton resetButton = new JButton("Обновить");
        ButtonHandler resetHandler = new ButtonHandler();
        resetButton.addActionListener(resetHandler);
        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComboBox myComboBox = new JComboBox(); //СОЗДАНИЕ КОМБО БОКСА
        /*ДОБАВЛЕНИЕ ВСЕХ ТИПОВ ФРАКТАЛОВ В КОМБО БОКС*/
        FractalGenerator mandelbrotFractal = new Mandelbrot();
        myComboBox.addItem(mandelbrotFractal);
        FractalGenerator tricornFractal = new Tricorn();
        myComboBox.addItem(tricornFractal);
        FractalGenerator burningShipFractal = new BurningShip();
        myComboBox.addItem(burningShipFractal);
        ButtonHandler fractalChooser = new ButtonHandler();
        myComboBox.addActionListener(fractalChooser);
        /*Создайте новый объект JPanel, добавьте к нему объекты JLabel и JComboBox,
         затем и добавить панель к раме в СЕВЕРНОЙ позиции. ПОЯСНЕНИЕ К ВЫПАДАЮЩЕМУ СПИСКУ*/
        JPanel myPanel = new JPanel();
        JLabel myLabel = new JLabel("Выберите Фрактал:"); //Пояснение к выпадающему списку
        myPanel.add(myLabel);
        myPanel.add(myComboBox);
        myFrame.add(myPanel, BorderLayout.NORTH);
        /*ДОБАВЛЕНИЕ КНОПКИ СОХРАНЕНИЯ*/
        JButton saveButton = new JButton("Сохранить");
        JPanel myBottomPanel = new JPanel();
        myBottomPanel.add(saveButton);
        myBottomPanel.add(resetButton);
        myFrame.add(myBottomPanel, BorderLayout.SOUTH);

        ButtonHandler saveHandler = new ButtonHandler();
        saveButton.addActionListener(saveHandler);

        myFrame.pack();
        myFrame.setVisible(true);
        myFrame.setResizable(false);
    }
    private void drawFractal()
    {
        for (int x=0; x<displaySize; x++){
            for (int y=0; y<displaySize; y++){
                double xCoord = fractal.getCoord(range.x,
                        range.x + range.width, displaySize, x);
                double yCoord = fractal.getCoord(range.y,
                        range.y + range.height, displaySize, y);
                int iteration = fractal.numIterations(xCoord, yCoord);
                if (iteration == -1){
                    display.drawPixel(x, y, 0);
                }
                else {
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    display.drawPixel(x, y, rgbColor);
                }

            }
        }
        display.repaint();
    }
    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            /*Получение источника действий. Добавление поддержки выпадающего списка*/
            String command = e.getActionCommand();
            if (e.getSource() instanceof JComboBox) {
                /*Если команда пришла из поля со списком, отображается выбранный пользователем фрактал*/
                JComboBox mySource = (JComboBox) e.getSource();
                fractal = (FractalGenerator) mySource.getSelectedItem();
                fractal.getInitialRange(range);
                drawFractal();

            }

            else if (command.equals("Обновить")) {
                /*Если команда пришла от кнопки сброса, сбросить отображение и нарисовать фрактал*/
                fractal.getInitialRange(range);
                drawFractal();
            }

            else if (command.equals("Сохранить")) {
                /*Если команда пришла от кнопки "сохранить", сохранить фрактал, который на экране*/
                JFileChooser myFileChooser = new JFileChooser();
                FileFilter extensionFilter =
                        /* Сохранять только .PNG изображения */
                        new FileNameExtensionFilter("PNG Images", "png");
                myFileChooser.setFileFilter(extensionFilter);
                /*Filechooser разрешит только имена файлов .png*/
                myFileChooser.setAcceptAllFileFilterUsed(false);
                /*Всплывающее окно "Сохранить файл"*/
                int userSelection = myFileChooser.showSaveDialog(display);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    /*Получить файл и его имя*/
                    java.io.File file = myFileChooser.getSelectedFile();
                    String file_name = file.toString();
                    /*Сохранение изображения фрактала на диск*/
                    try {
                        BufferedImage displayImage = display.getImage();
                        javax.imageio.ImageIO.write(displayImage, "png", file);
                    }

                    catch (Exception exception) {
                        JOptionPane.showMessageDialog(display,
                                exception.getMessage(), "Не могу сохранить изображение",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
                else return;
            }
        }
    }

    private class MouseHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x,
                    range.x + range.width, displaySize, x);

            int y = e.getY();
            double yCoord = fractal.getCoord(range.y,
                    range.y + range.height, displaySize, y);

            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }

    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(600);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}
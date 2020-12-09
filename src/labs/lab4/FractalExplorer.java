package labs.lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

/**
 * Этот класс предназначен для того, чтобы пользователь мог исследовать различные фрактальные области.**/
public class FractalExplorer {
    private final int displaySize;
    private final JImageDisplay display;
    private final FractalGenerator fractalGenerator;
    private final Rectangle2D.Double range;

    /** Конструктор класса**/
    public FractalExplorer(int size) {
        displaySize = size;
        /* Инициализация FractalGenerator и диапазон objects. */
        fractalGenerator = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractalGenerator.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);
    }

    /**Создает и отображает графический интерфейс**/
    public void createAndShowGUI()
    {
        /* Устанавливает фрейм для использования BorderLayout для своего содержимого.**/
        display.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Проверка фракталов");

        /* Помещает объект отображения изображения в центральное положение */
        frame.add(display, BorderLayout.CENTER);

        /* Создает кнопку сброса (обновления окна) */
        JButton resBut = new JButton("Перезагрузить все");

        /* Сбросить экземпляр по кнопке сброса. */
        Reset handler = new Reset();
        resBut.addActionListener(handler);

        /* Ставит кнопку в южное положение*/
        frame.add(resBut, BorderLayout.SOUTH);

        /* Экземпляр мыши на компоненте отображения фрактала. */
        Mouse click = new Mouse();
        display.addMouseListener(click);

        /* Установите операцию закрытия фрейма по умолчанию для выхода */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Упаковывает содержимое фрейма, делая его видимым и запрещая изменение размера окна */
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * Отображает фрактал. Перебирает каждый пиксель и устанавливает его цвет в зависимости от количества итераций.
     * Затем перерисовывает JImageDisplay со всеми новыми пикселями
     */
    private void drawFractal()
    {
        for (int x=0; x<displaySize; x++){
            for (int y=0; y<displaySize; y++){
                /* Нахождение координаты xCoord и yCoord в области отображения фрактала */
                double xCoord = FractalGenerator.getCoord(range.x,
                        range.x + range.width, displaySize, x);
                double yCoord = FractalGenerator.getCoord(range.y,
                        range.y + range.height, displaySize, y);
                /* Вычисление количества итераций в области отображения*/
                int iteration = fractalGenerator.numIterations(xCoord, yCoord);
                if (iteration == -1){
                    display.drawPixel(x, y, 0);
                }
                else {
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    /* Обновление экрана с новыми пикселями */
                    display.drawPixel(x, y, rgbColor);
                }
            }
        }
        /* Перекрасить JImageDisplay в соответствии с текущим содержимым его изображения */
        display.repaint();
    }

    private class Reset implements ActionListener{
        /* Сбрасывает диапазон до начального диапазона и рисует фрактал */
        public void actionPerformed(ActionEvent e) {
            fractalGenerator.getInitialRange(range);
            drawFractal();
        }
    }

    /**
     * Класс, предназначенный для обработки событий MouseListener
     */
    private class Mouse extends MouseAdapter {
        /**
         * Получив метод щелчка мышью, отображает пиксель, по которому щелкнули, и вызывает recenterAndZoomRange ()
         * Затем перерисовывает фрактал
         * **/
        public void mouseClicked(MouseEvent e) {
            /* Получение координаты X нажатия мыши */
            int x = e.getX();
            double xCoord = FractalGenerator.getCoord(range.x,
                    range.x + range.width, displaySize, x);

            /* Получение координаты Y нажатия мыши */
            int y = e.getY();
            double yCoord = FractalGenerator.getCoord(range.y,
                    range.y + range.height, displaySize, y);
            fractalGenerator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }

    /**
     * Запускает FractalExplorer
     */
    public static void main(String[] args) {
        FractalExplorer display = new FractalExplorer(800);
        display.createAndShowGUI();
        display.drawFractal();
    }
}
package labs.lab4;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    /*Константа для количества максимального количества итераций */
    public static final int MAX_ITERATIONS = 2000;

    public void getInitialRange(Rectangle2D.Double range){
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    public int numIterations(double x, double y)
    {
        /* Начало итерации с 0 */
        int iterNum = 0;
        double zReal = 0; // реальная часть z
        double zImaginary = 0; // Мнимая часть z

        /**
         * Вычисление Z[n]=Z[n-1]^2+c
         * zReal и zImaginary являются частями комплексного числа. C - особая точка фрактала,
         * задано x, y. Итерация до | z |> 2 или до достижения максимального количества итераций
         * **/
        while (iterNum < MAX_ITERATIONS && zReal * zReal + zImaginary * zImaginary < 4) {
            double zrealUpdated = zReal * zReal - zImaginary * zImaginary + x;
            double zimaginaryUpdated = 2 * zReal * zImaginary + y;
            zReal = zrealUpdated;
            zImaginary = zimaginaryUpdated;
            iterNum += 1;
        }

        /**
         * Возвращает -1, чтобы показать, что точка находится внутри границы
         */
        if (iterNum == MAX_ITERATIONS) {
            return -1;
        }
        return iterNum;
    }
}
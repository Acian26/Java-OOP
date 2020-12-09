package labs.lab5;

import java.awt.geom.Rectangle2D;

public class Tricorn extends FractalGenerator {
    /*Константа для количества максимального количества итераций*/
    public static final int MAX_ITERATIONS = 2000;

    public void getInitialRange(Rectangle2D.Double range){ //ПОМЕНЯЛИ ДИАПАЗОН
        range.x = -2;
        range.y = -2;
        range.width = 4;
        range.height = 4;
    }

    public int numIterations(double x, double y)
    {
        /* Start iteration with 0 count */
        int iterNum = 0;
        double zReal = 0; // Real z part
        double zImaginary = 0; // Imaginary z part

        /*
         * Вычисляет Z[n]=Z[n-1]^2+С. Комплексное сопряжение на каждой итерации (Z[n-1])
         * zReal и zImaginary являются частями комплексного числа. C - особая точка фрактала,
         * задается x, y. Итерация до | z |> 2 или до достижения максимального количества итераций
         * */
        while (iterNum < MAX_ITERATIONS && zReal * zReal + zImaginary * zImaginary < 4) {
            double zrealUpdated = zReal * zReal - zImaginary * zImaginary + x;
            double zimaginaryUpdated = -2 * zReal * zImaginary + y;
            zReal = zrealUpdated;
            zImaginary = zimaginaryUpdated;
            iterNum += 1;
        }

        /*
         * Возвращает -1, чтобы показать, что точка находится внутри границы
         */
        if (iterNum == MAX_ITERATIONS) {
            return -1;
        }
        return iterNum;
    }

    public String toString(){ //ВОЗВРАЩЕНИЕ ИМЕНИ ФРАКТАЛА
        return "Tricorn";
    }
}
package labs.laba2;

public class Poind2d
{
    private double xCoord;								// Координата X
    private double yCoord;                              // Координата Y

    public Poind2d(double x, double y)					// Конструктор инициализации
    {
        xCoord = x;
        yCoord = y;
    }
    public Poind2d()
    {
        this(0,0);
    }
    public double getX()								// Возвращение координаты X
    {
        return xCoord;
    }
    public double getY()								// Возвращение координаты Y
    {
        return yCoord;
    }
    public void setX(double val)						// Установка значения координаты X
    {
        xCoord = val;
    }
    public void setY(double val)						// Установка значения координаты Y
    {
        yCoord = val;
    }
    public static boolean compare(Poind2d a, Poind2d b)	// Сравнение значений точек
    {
        if ((a.getX() == b.getX()) && (a.getY() == b.getY()))
            return true;
        else
            return false;
    }
}
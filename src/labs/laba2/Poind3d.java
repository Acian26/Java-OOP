package labs.laba2;
import java.util.Scanner;

public class Poind3d extends Poind2d {

    static  double sqr (double a ) {   //метод для возведения числа в квадрат
        double result = a*a;
        return result;
    }
    public static void main(String[] args)

    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите по очереди координаты для первой точки: " + "\n");
        double a = in.nextInt();
        double b = in.nextInt();
        double c = in.nextInt();
        System.out.print("Введите по очереди координаты для второй точки: " + "\n");
        double a1 = in.nextInt();
        double b1 = in.nextInt();
        double c1 = in.nextInt();
        Poind3d Point = new Poind3d(a,b,c);
        Poind3d Point1 = new Poind3d(a1,b1,c1);

        Point.setX(a);
        Point1.setX(a1);

        Point.setY(b);
        Point1.setY(b1);

        in.close();  //Останавливаем работу Scanner

        if(compare(Point, Point1))  //Сравниваем координаты точек
            System.out.println("Точки имеют одинаковые координаты.");
        else {
            System.out.println("Точки имеют разные координаты.");//Если расстояние между точками разное
            System.out.println("Расстояние между точками: ");   //Рассчитываем расстояние между точками
            System.out.print(distanceTo(Point, Point1));
        }
    }

    private double zCoord;  // Координата Z

    public Poind3d(double x, double y, double z)// Конструктор инициализации
    {
        // Координата X
        // Координата Y
        zCoord = z;
    }
    public Poind3d()
    {
        this(0, 0, 0);
    }

    public double getZ()		 // Возвращение координаты Z
    {
        return zCoord;
    }
    public void setZ(double val)   // Установка значения координаты Z
    {
        zCoord = val;
    }
    public static boolean compare(Poind3d a, Poind3d b)	 // Сравнение значений точек
    {
        return (a.getX() == b.getX()) && (a.getY() == b.getY()) && (a.getZ() == b.getZ());
    }
    public static double distanceTo(Poind3d a, Poind3d b)			// Нахождение расстояния между точками
    {
        double Round = Math.sqrt(sqr((b.getX()-a.getX())) + sqr((b.getY()-a.getY())) + sqr((b.getZ()-a.getZ())));
        Round *= 100;
        Round = (int) Round;
        return (Round / 100);
    }
}
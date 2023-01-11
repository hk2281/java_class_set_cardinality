// класс Прямоугольник

public class Rectangle {

    private double a; // строна 1
    private double b; // строна 2

    // конструктор без начальной инициализации
    public Rectangle() {
        a=0.0;
        b=0.0;
    }

    // конструктор с начальной инициализацией
    public Rectangle(double a, double b){
        this.a=a;
        this.b=b;
    }

    // конструктор копирования
    public Rectangle(Rectangle t) {
        this.a=t.a;
        this.b=t.b;
    }

    // доступ к private-членам класса
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        // преобразование объекта в строку
        return "Прямоугольник со сторонами " + a + " и " + b + ".";
    }

    // вычисление площади прямоугольника
    public double getSquare() {
        return (a * b);
    }

    // вычисление периметра прямоугольника
    public  double getPerimeter() {
        return 2*(a+b);
    }

    // является квадратом?
    public boolean isQuadrate() {
        return a==b;
    }

    public static void main(String[] args) {

        // создание объекта с инициализацией
        Rectangle rec1 = new Rectangle(25.0, 32.0);
        System.out.println("Четырехугольник rec1: " + rec1);

        if(rec1.isQuadrate())
            System.out.println("Четырехугольник является квадратом");
        else
            System.out.println("Четырехугольник не является квадратом");

        // создание объекта без инициализации
        Rectangle rec2 = new Rectangle();
        rec2.setA(10.5);
        rec2.setB(10.5);
        System.out.println("\nЧетырехугольник rec2: " + rec2);
        System.out.println("Площадь rec2: " + rec2.getSquare());
        System.out.println("Периметр rec2: " + rec2.getPerimeter());

        if(rec2.isQuadrate())
            System.out.println("Четырехугольник является квадратом");
        else
            System.out.println("Четырехугольник не является квадратом");

        // создание объекта копированием
        Rectangle rec4 = new Rectangle(rec2);
        System.out.println("\nЧетырехугольник rec4: " + rec4);

    }
}

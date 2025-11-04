import java.util.Scanner;

abstract class shape{
    int a;
    int b;
    abstract void printArea();
}

class Rectangle extends shape{
    Rectangle(int x, int y){
        a=x;
        b=y;
    }
    void printArea(){
    System.out.println("Area of Rectange="+(a * b));
}
}

class Triangle extends shape{
    Triangle(int x, int y){
        a=x;
        b=y;
    }
    void printArea(){
        System.out.println("Area of Triangle="+ (a * b * 0.5));
    }
}

class Circle extends shape{
    Circle(int r){
        a = r;
    }
    void printArea(){
        System.out.println("Area of Circle = "+ (Math.PI * a * a));
    }
}
 public class lab4{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        shape s;

        System.out.println("Enter the Dimesnisons of the Rectangle:");
        int rectlength = sc.nextInt();
        int rectheight = sc.nextInt();
        s=new Rectangle(rectlength,rectheight);
        s.printArea();

        System.out.println("Enter the Dimensions of the Triangle:");
        int triBase = sc.nextInt();
        int triHeight = sc.nextInt();
        s=new Triangle(triBase,triHeight);
        s.printArea();

        System.out.println("Enter the Dimensions of the Circle:");
        int circleRadius = sc.nextInt();
        s=new Circle(circleRadius);
        s.printArea();
        sc.close();
    }
 }

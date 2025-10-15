import java.util.*;
public class lab1{
    public static void main(String[] args){
        double a,b,c,d;
        Scanner Sc= new Scanner(System.in);

        System.out.println("Enter the value of a:");
        a=Sc.nextInt();

        System.out.println("Enter the value of b:");
        b=Sc.nextInt();

        System.out.println("Enter the value of c:");
        c=Sc.nextInt();

        if(a==0){
            System.out.print("Not a Quadratic Equation.");
        }

        else{
            d=b*b-4*a*c;
            
            if(d==0){
                double r1=(-b)/(2*a);
                System.out.println("Roots are real and equal.");
                System.out.println("roots"+r1);
            }

            else if(d>0){
                double r1=((-b)+(Math.sqrt(d)))/(double)(2*a);
                double r2=((-b)-(Math.sqrt(d)))/(double)(2*a);
                System.out.println("roots are"+r1);
                System.out.println("roots are"+r2);
            }
            else if(d<0){
                System.out.println("Roots are imaginary.");
                double r1=(-b)/(2*a);
                double r2=Math.sqrt(-d)/(2*a);
                System.out.println("Roots are"+r1);
                System.out.println("Roots are"+r2);
            }
        }
    }
}

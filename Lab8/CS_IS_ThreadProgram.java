class CS extends Thread
{
public void run()
{
for(int i=1; i<=5; i++)
System.out.println("Computer Science " + i);
}
}

class IS extends Thread
{
public void run()
{
for(int i=1; i<=5; i++)
System.out.println("Information Science " + i);
}
}

public class CS_IS_ThreadProgram {
public static void main(String args[])
{
CS c1 = new CS();
c1.start();

IS i1 = new IS();
i1.start();
}
}
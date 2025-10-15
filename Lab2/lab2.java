import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int n;  

    Student(int n) {
        this.n = n;
        credits = new int[n];
        marks = new int[n];
    }

    void accept(Scanner sc) {
        System.out.print("Enter USN: ");
        usn = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.println("Enter credits and marks for " + n + " subjects:");

        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + " credits: ");
            credits[i] = sc.nextInt();

            System.out.print("Subject " + (i + 1) + " marks (0-100): ");
            marks[i] = sc.nextInt();
        }
        sc.nextLine(); 
    }

    int getGradePoint(int mark) {
        if (mark >= 90) return 10;
        else if (mark >= 80) return 9;
        else if (mark >= 70) return 8;
        else if (mark >= 60) return 7;
        else if (mark >= 50) return 6;
        else if (mark >= 40) return 4;
        else return 0;
    }

    double calculateSGPA() {
        int totalCredits = 0;
        int weightedPoints = 0;

        for (int i = 0; i < n; i++) {
            int gp = getGradePoint(marks[i]);
            weightedPoints += gp * credits[i];
            totalCredits += credits[i];
        }

        if (totalCredits == 0) return 0.0;

        return (double) weightedPoints / totalCredits;
    }

    void display() {
        System.out.println("\nStudent Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Credits and Marks:");
        for (int i = 0; i < n; i++) {
            System.out.println("Subject " + (i + 1) + ": Credits = " + credits[i] + ", Marks = " + marks[i]);
        }
        System.out.printf("SGPA: %.2f\n", calculateSGPA());
    }
}

public class lab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();
        sc.nextLine(); 

        int numStudents = 2;  
        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            students[i] = new Student(subjects);
            students[i].accept(sc);
        }

        System.out.println("\n--- Displaying student details ---");
        for (int i = 0; i < numStudents; i++) {
            students[i].display();
        }

        sc.close();
    }
}
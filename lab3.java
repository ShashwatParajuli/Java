import java.util.Scanner;

class Book {
    String name;
    String author;
    double price;
    int num_pages;

    public Book(String name, String author, double price, int num_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getNumPages() {
        return num_pages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumPages(int num_pages) {
        this.num_pages = num_pages;
    }

    @Override
    public String toString() {
        return "Book [Name=" + name + ", Author=" + author + ", Price=" + price + ", Pages=" + num_pages + "]";
    }
}

public class lab3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books to create: ");
        int n = sc.nextInt();
        sc.nextLine();  

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for book " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Number of pages: ");
            int pages = sc.nextInt();
            sc.nextLine();  

            books[i] = new Book(name, author, price, pages);
        }

        System.out.println("\nBook Details:");
        for (Book book : books) {
            System.out.println(book);
        }

        sc.close();
    }
}


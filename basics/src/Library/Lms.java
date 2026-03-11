package basics;
import java.util.*;

public class Lms {

    class Book {
        String title;
        boolean available;
        int price;
        Book(String title, int price) {
            this.title = title;
            this.available = true;
            
            if (price >= 0) {
                this.price = price;
                System.out.println("The price is valid");
            } else {
                this.price = 0;
                System.out.println("The price is invalid, set to 0");
            }
        }

        String status() {
            return available ? "Available" : "Borrowed";
        }
    }

    class Library {
        List<Book> books = new ArrayList<>();

        void addBook(String title, int price) {
            books.add(new Book(title, price));
        }

        void borrowBook(String title) {
            for (Book b : books) {
                if (b.title.equals(title) && b.available) {
                    b.available = false;
                    System.out.println("Borrowed: " + title);
                    return;
                }
            }
            System.out.println("Book not available");
        }

        Book find(String title) {
            for (Book b : books) {
                if (b.title.equals(title)) {
                    return b;
                }
            }
            return null;
        }

        void displayBooks() {
            System.out.println("Library Books:");
            for (Book b : books) {
                System.out.println(b.title + " - " + b.status() + " - $" + b.price);
            }
        }
    }

    public static void main(String[] args) {
        Lms lms = new Lms();
        Library library = lms.new Library();

        library.addBook("Java Basics", 50);
        library.addBook("Python Basics", -10); 
        library.addBook("Data Structures", 70);

        library.displayBooks();

        library.borrowBook("Java Basics");
        library.borrowBook("Nonexistent Book");

        library.displayBooks();

        Book found = library.find("Data Structures");
        if (found != null) {
            System.out.println("Found book: " + found.title + " - Status: " + found.status());
        }
    }
}

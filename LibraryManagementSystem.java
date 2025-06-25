
import java.util.*;

class Book {
    String id, title, author;
    boolean isIssued;

    Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String toString() {
        return id + " | " + title + " by " + author + " | " + (isIssued ? "Issued" : "Available");
    }
}

public class LibraryManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Library Menu ====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List All Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search Book");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> listBooks();
                case 4 -> issueBook();
                case 5 -> returnBook();
                case 6 -> searchBook();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        String id = sc.nextLine();
        books.removeIf(book -> book.id.equals(id));
        System.out.println("Book removed if ID existed.");
    }

    static void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            books.forEach(System.out::println);
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        String id = sc.nextLine();
        for (Book book : books) {
            if (book.id.equals(id)) {
                if (!book.isIssued) {
                    book.isIssued = true;
                    System.out.println("Book issued.");
                } else {
                    System.out.println("Book already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        String id = sc.nextLine();
        for (Book book : books) {
            if (book.id.equals(id)) {
                if (book.isIssued) {
                    book.isIssued = false;
                    System.out.println("Book returned.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void searchBook() {
        System.out.print("Enter keyword (title/author): ");
        String keyword = sc.nextLine().toLowerCase();
        for (Book book : books) {
            if (book.title.toLowerCase().contains(keyword) || book.author.toLowerCase().contains(keyword)) {
                System.out.println(book);
            }
        }
    }
}

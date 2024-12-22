import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

public class LibraryCatalog 
{
    private ArrayList<Book> books;
    private Scanner scanner;

    public LibraryCatalog() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() 
    {
        while (true) 
        {
            System.out.println("\nLibrary Catalog System:");
            System.out.println("1. Add a book");
            System.out.println("2. Search by title");
            System.out.println("3. Search by author");
            System.out.println("4. List all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> addBook();
                case 2 -> searchByTitle();
                case 3 -> searchByAuthor();
                case 4 -> listBooks();
                case 5 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author: ");
        String author = scanner.nextLine();
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    private void searchByTitle() {
        System.out.print("Enter the title to search: ");
        String title = scanner.nextLine();
        System.out.println("Search Results:");
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the title \"" + title + "\".");
        }
    }

    private void searchByAuthor() {
        System.out.print("Enter the author to search: ");
        String author = scanner.nextLine();
        System.out.println("Search Results:");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by the author \"" + author + "\".");
        }
    }

    private void listBooks() {
        System.out.println("Listing all books:");
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        catalog.start();
    }
}

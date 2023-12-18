import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class BookStoreApp {
    private static BookDao bookDao = new BookDaoImpl(JDBConnection.getConnection());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("""
                    Welcome to the Book Store App!
                    Please select one of the following:
                    1. Add a new book
                    2. Update a book
                    3. Delete a book
                    4. Display a book
                    5. Display all books
                    6. Exit
                    """);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    updateBook(sc);
                    break;
                case 3:
                    deleteBook(sc);
                    break;
                case 4:
                    readBookById(sc);
                    break;
                case 5:
                    displayBooks(sc);
                    break;
                case 6:
                    System.out.println("Exiting Application...");
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        } while (choice != 6);

    }

    private static void displayBooks(Scanner sc) {
        for (Book book : bookDao.getAllBooks()) {
            System.out.println(book);
        }
    }

    private static void readBookById(Scanner sc) {
        System.out.println("Please enter book ID: ");
        int bookId = sc.nextInt();
        Book book = bookDao.getBookById(bookId);
        if(book == null){
            System.out.println("No book found.");
        } else {
        System.out.println(book);}
    }

    private static void deleteBook(Scanner sc) {

    }

    private static void updateBook(Scanner sc) {

    }

    private static void addBook(Scanner sc) {
        System.out.println("Please enter Book title: ");
        String title = sc.nextLine();
        System.out.println("Please enter Book author: ");
        String author = sc.nextLine();
        System.out.println("Please enter Book genre: ");
        String genre = sc.nextLine();
        System.out.println("Please enter Book price: ");
        double price = sc.nextDouble();

        Book book = new Book (title, author, genre, price);

        bookDao.addBook(book);

        System.out.println("Book added successfully!");
    }
}

package lab4;

class Book implements Comparable<Book> {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private double price;

    public Book(int id, String title, String author, String publisher, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getPrice() {
        return price;
    }

    
    public int compareTo(Book other) {
        return Double.compare(this.price, other.price);
    }
}

package lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookDatabase {
    private List<Book> books;

    public BookDatabase() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void sortBooksByPrice() {
        Collections.sort(books);
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }

    public List<Book> getBooksByPublisher(String publisher) {
        List<Book> abovePriceBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                abovePriceBooks.add(book);
            }
        }
        return abovePriceBooks;
    }

    public static void main(String[] args) {
        BookDatabase db = new BookDatabase();

        db.addBook(new Book(1, "Book1", "Author1", "Publisher1", 20.0));
        db.addBook(new Book(2, "Book2", "Author2", "Publisher2", 30.0));
        db.addBook(new Book(3, "Book3", "Author1", "Publisher3", 10.0));
        db.addBook(new Book(4, "Book4", "Author3", "Publisher4", 40.0));
        db.addBook(new Book(5, "Book5", "Author2", "Publisher5", 25.0));

        db.sortBooksByPrice();

        System.out.println("Sorted books by price:");
        for (Book book : db.books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - " + book.getPrice());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        List<Book> authorBooks = db.getBooksByAuthor(author);
        System.out.println("Books by " + author + ":");
        for (Book book : authorBooks) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - " + book.getPrice());
        }

        System.out.print("Enter Publisher name: ");
        String publisher = scanner.nextLine();

        List<Book> abovePriceBooks = db.getBooksByPublisher(publisher);
        System.out.println("Books by " + publisher + ":");
        for (Book book : abovePriceBooks) {
            System.out.println(book.getTitle() + " by " + book.getPublisher() + " - " + book.getPrice());
        }
    }
}

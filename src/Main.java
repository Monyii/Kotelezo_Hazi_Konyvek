import jakarta.persistence.criteria.CriteriaBuilder;
import model.Author;
import model.Status;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private Controller controller;


    private void mainMenu(Scanner sc) {
        String option = "ghyt";
        do {
            switch (option) {
                case "t" -> searchMenu();
                case "nb" -> {
                    System.out.println("Add Book title: ");
                    String title = sc.nextLine();
                    System.out.println("Add Book Author name: ");
                    String author = sc.nextLine();
                    System.out.println("Add Book isbn: ");
                    String isbn = sc.nextLine();
                    sc.nextLine();

                    controller.addNewBook(title, author, isbn);
                }
                case "b" -> controller.getAllBook();
                case "mb" -> {
                    //todo Modify book menu
                }
                case "na" -> {
                    System.out.println("Add Author name: ");
                    String name = sc.nextLine();
                    System.out.println("Add Author nationality: ");
                    String nationality = sc.nextLine();
                    sc.nextLine();

                    controller.addNewAuthor(name, nationality);
                }
                case "a" -> controller.getAllAuthor();
                case "ma" -> {
                    //todo Modify author menu
                }
                case "da" -> {
                    System.out.println("Author id: ");
                    Integer id = sc.nextInt();
                    sc.nextLine();

                    controller.deleteAuthor(id);
                }
                case "ns" -> {
                    System.out.println("Add the Store name: ");
                    String name = sc.nextLine();
                    System.out.println("Add Store Address: ");
                    String address = sc.nextLine();
                    System.out.println("Active or Passive? ");
                    String status = sc.nextLine();
                    controller.addNewStore(name, address, Status.valueOf(status));
                }

                case "s" -> controller.getAllStore();
                case "ms" -> {
                    //todo Modify store menu
                }
                default -> {
                    if (!option.equalsIgnoreCase("ghyt")) {
                        System.out.println("Nem ismert opcio...");
                    }
                }
            }

            printMenu();
            System.out.println("Mit lepsz?");
        } while (!"q".equalsIgnoreCase(option = sc.nextLine()));
    }

    private void searchMenu(Scanner sc) {
        String option = "ghyt";
        do {
            switch (option) {
                case "qb" -> bookSearch();
                case "qa" -> authorSearch();
                case "qs" -> storeSearch();
                default -> {
                    if (!option.equalsIgnoreCase("ghyt")) {
                        System.out.println("Nem ismert opcio...");
                    }
                }
            }
            searchMenu();
            System.out.println("Mit lepsz?");
        } while (!"q".equalsIgnoreCase(option = sc.nextLine()));
    }

    private void searchBookMenu(Scanner sc) {
        String option = "ghyt";
        do {
            switch (option) {
                case "i" -> {
                    System.out.println("Book Id:");
                    Integer id = sc.nextInt();
                    sc.nextLine();
                    controller.searchBookById(id); //todo
                }
                case "t" -> {
                    System.out.println("Book Title:");
                    String title = sc.nextLine();
                    sc.nextLine();
                    controller.searchBookByTitle(title); //todo
                }
                case "a" -> {
                    System.out.println("Book Author:");
                    String author = sc.nextLine();
                    sc.nextLine();
                    controller.searchBookByAuthor(author); //todo
                }
                case "b" -> {
                    System.out.println("Book Isbn:");
                    String isbn = sc.nextLine();
                    sc.nextLine();
                    controller.searchBookByIsbn(isbn); //todo
                }
                default -> {
                    if (!option.equalsIgnoreCase("ghyt")) {
                        System.out.println("Nem ismert opcio...");
                    }
                }
            }
            storeSearch();
            System.out.println("Mit lepsz?");
        } while (!"q".equalsIgnoreCase(option = sc.nextLine()));
    }

    private void searchAuthorMenu(Scanner sc) {
        String option = "ghyt";
        do {
            switch (option) {
                case "i" -> {
                    System.out.println("Author Id:");
                    Integer id = sc.nextInt();
                    sc.nextLine();
                    controller.searchAuthorById(id); //todo
                }
                case "n" -> {
                    System.out.println("Author Name:");
                    String name = sc.nextLine();
                    sc.nextLine();
                    controller.searchAuthorByName(name); //todo
                }
                case "a" -> {
                    System.out.println("Author Nationality:");
                    String nationality = sc.nextLine();
                    sc.nextLine();
                    controller.searchAuthorByNationality(nationality); //todo
                }
                default -> {
                    if (!option.equalsIgnoreCase("ghyt")) {
                        System.out.println("Nem ismert opcio...");
                    }
                }
            }
            authorSearch();
            System.out.println("Mit lepsz?");
        } while (!"q".equalsIgnoreCase(option = sc.nextLine()));
    }

    private void searchStoreMenu(Scanner sc) {
        String option = "ghyt";
        do {
            switch (option) {
                case "i" -> {
                    System.out.println("Store Id:");
                    Integer id = sc.nextInt();
                    sc.nextLine();
                    controller.searchStoreById(id); //todo
                }
                case "n" -> {
                    System.out.println("Store Name:");
                    String name = sc.nextLine();
                    sc.nextLine();
                    controller.searchStoreByName(name); //todo
                }
                case "a" -> {
                    System.out.println("Store Address:");
                    String address = sc.nextLine();
                    sc.nextLine();
                    controller.searchStoreByAddress(address); //todo
                }
                case "s" -> {
                    System.out.println("Store Status:");
                    String status = sc.nextLine();
                    sc.nextLine();
                    controller.searchStoreByStatus(status); //todo
                }
                case "o" -> {
                    System.out.println("Store Stock:");
                    Integer stock = sc.nextInt();
                    sc.nextLine();
                    controller.searchStoreByStock(stock); //todo
                }
                default -> {
                    if (!option.equalsIgnoreCase("ghyt")) {
                        System.out.println("Nem ismert opcio...");
                    }
                }
            }
            bookSearch();
            System.out.println("Mit lepsz?");
        } while (!"q".equalsIgnoreCase(option = sc.nextLine()));
    }

    private void bookSearch() {
        System.out.println("Search by Id - (i)");
        System.out.println("Search by Title - (t)");
        System.out.println("Search by Author - (a)");
        System.out.println("Search by Isbn - (b)");
    }

    private void authorSearch() {
        System.out.println("Search by Id - (i)");
        System.out.println("Search by Name - (n)");
        System.out.println("Search by Nationality - (a)");
    }

    private void storeSearch() {
        System.out.println("Search by Id - (i)");
        System.out.println("Search by Name - (n)");
        System.out.println("Search by Address - (a)");
        System.out.println("Search by Status - (s)");
        System.out.println("Search by Stock - (o)");
    }

    private void searchMenu() {
        System.out.println("=".repeat(30));
        System.out.println("\tBook - (qb)");
        System.out.println("\tAuthor - (qa)");
        System.out.println("\tStore - (qs)");
    }

    private void printMenu() {
        System.out.println("=".repeat(30));
        System.out.println("\tSearch - (t)");
        System.out.println("\t-------------------------");
        System.out.println("\tAdd new Book - (nb)");
        System.out.println("\tGet all Book - (b)");
        System.out.println("\tModify Book - (mb)");
        System.out.println("\t-------------------------");
        System.out.println("\tAdd new Author - (na)");
        System.out.println("\tGet all Author - (a)");
        System.out.println("\tModify Author - (ma)");
        System.out.println("\tDelete Author - (da)");
        System.out.println("\t-------------------------");
        System.out.println("\tAdd new Store - (ns)");
        System.out.println("\tGet all Store - (s)");
        System.out.println("\tModify Store - (ms)");
        System.out.println("\t-------------------------");
        System.out.println("\tKilepes - (q)");
        System.out.println("=".repeat(30));
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();

        try (
                Scanner sc = new Scanner(System.in);
                Controller c = new Controller()
        ) {
            m.controller = c;
            m.mainMenu(sc);
        }
    }

}

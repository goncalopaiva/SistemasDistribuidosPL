package edu.ufp.inf.sd.rmi._04_diglib.client;

import edu.ufp.inf.sd.rmi._01_helloworld.server.HelloWorldRI;
import edu.ufp.inf.sd.rmi._04_diglib.server.Book;
import edu.ufp.inf.sd.rmi._04_diglib.server.DigLibFactoryRI;
import edu.ufp.inf.sd.rmi._04_diglib.server.DigLibSessionRI;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * Title: Projecto SD</p>
 * <p>
 * Description: Projecto apoio aulas SD</p>
 * <p>
 * Copyright: Copyright (c) 2017</p>
 * <p>
 * Company: UFP </p>
 *
 * @author Rui S. Moreira
 * @version 3.0
 */
public class DigLibClient {

    /**
     * Context for connecting a RMI client MAIL_TO_ADDR a RMI Servant
     */
    private SetupContextRMI contextRMI;
    /**
     * Remote interface that will hold the Servant proxy
     */
    private DigLibSessionRI digLibSessionRI;
    private DigLibFactoryRI digLibFactoryRI;

    public static void main(String[] args) {
        if (args != null && args.length < 2) {
            System.err.println("usage: java [options] edu.ufp.sd.inf.rmi._01_helloworld.server.HelloWorldClient <rmi_registry_ip> <rmi_registry_port> <service_name>");
            System.exit(-1);
        } else {
            //1. ============ Setup client RMI context ============
            DigLibClient dlc = new DigLibClient(args);
            //2. ============ Lookup service ============
            dlc.lookupService();
            //3. ============ Play with service ============
            dlc.playService();
        }
    }

    public DigLibClient(String args[]) {
        try {
            //List ans set args
            SetupContextRMI.printArgs(this.getClass().getName(), args);
            String registryIP = args[0];
            String registryPort = args[1];
            String serviceName = args[2];
            //Create a context for RMI setup
            contextRMI = new SetupContextRMI(this.getClass(), registryIP, registryPort, new String[]{serviceName});
        } catch (RemoteException e) {
            Logger.getLogger(DigLibClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Remote lookupService() {
        try {
            //Get proxy MAIL_TO_ADDR rmiregistry
            Registry registry = contextRMI.getRegistry();
            //Lookup service on rmiregistry and wait for calls
            if (registry != null) {
                //Get service url (including servicename)
                String serviceUrl = contextRMI.getServicesUrl(0);
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "going MAIL_TO_ADDR lookup service @ {0}", serviceUrl);

                //============ Get proxy MAIL_TO_ADDR HelloWorld service ============
                digLibFactoryRI = (DigLibFactoryRI) registry.lookup(serviceUrl);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "registry not bound (check IPs). :(");
                //registry = LocateRegistry.createRegistry(1099);
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return digLibFactoryRI;
    }

    private void playService() {
        try {
            System.out.println("***** DIGITAL LIBRARY *****");
            //loginMenu();
            //menuOptions();
            //searchBook();


            String title, author;
            Scanner input = new Scanner(System.in);

            System.out.println();
            System.out.println("*** SEARCH BOOK ***");

            System.out.println();
            System.out.println("What is the title of the book? ");
            title = input.next();

            System.out.println();
            System.out.println("What is the author of the book? ");
            author = input.next();

            Book[] books;
            books = this.digLibSessionRI.search(title, author);

            if (books.length == 0) {
                System.out.println("There is no match.");
            } else {
                int i = 0;
                for (Book b : books) {
                    System.out.println();
                    System.out.println("Match #" + i);
                    System.out.println("\tTitle: " + b.getTitle());
                    System.out.println("\tAuthor: " + b.getAuthor());
                }
            }

        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loginMenu() throws RemoteException {
        String username, password;
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("*** LOGIN ***");
        System.out.print("\tLogin: ");
        username = input.next();
        System.out.print("\tPassword: ");
        password = input.next();

        digLibFactoryRI.login(username, password);

        System.out.println();
        System.out.println("Hello, " + username);
    }

    private void menuOptions() throws RemoteException {
        char opt;
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("What do you want to do today? ");
        System.out.println("1. Search a book.");
        System.out.println("2. Insert a book.");
        opt = input.next().charAt(0);

        if (opt == 1) {
            searchBook();
        }
        else if (opt == 2) {
            //Insert a new book
            System.out.println("Insert new book is not available at the moment.");
        }

    }

    private void searchBook() throws RemoteException {
        String title, author;
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("*** SEARCH BOOK ***");

        System.out.println();
        System.out.println("What is the title of the book? ");
        title = input.next();

        System.out.println();
        System.out.println("What is the author of the book? ");
        author = input.next();

        Book[] books;
        books = this.digLibSessionRI.search(title, author);

        if (books.length == 0) {
            System.out.println("There is no match.");
        } else {
            int i = 0;
            for (Book b : books) {
                System.out.println();
                System.out.println("Match #" + i);
                System.out.println("\tTitle: " + b.getTitle());
                System.out.println("\tAuthor: " + b.getAuthor());
            }
        }
    }


}
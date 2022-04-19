package edu.ufp.inf.sd.rmi._04_diglib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DigLibSessionRI extends Remote {

    /**
     * Search books
     * @param title - title of the book
     * @param author - author of the book
     * @return
     * @throws RemoteException
     */
    Book[] search(String title, String author) throws RemoteException;

    void logout() throws RemoteException;



}

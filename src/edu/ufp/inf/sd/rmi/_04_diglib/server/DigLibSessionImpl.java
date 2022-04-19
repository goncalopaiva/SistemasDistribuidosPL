package edu.ufp.inf.sd.rmi._04_diglib.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DigLibSessionImpl extends UnicastRemoteObject implements DigLibSessionRI {

    private DBMockup dbMockup;
    private DigLibFactoryRI digLibFactoryRI;

    public DigLibSessionImpl() throws RemoteException {
        super();
    }

    @Override
    public Book[] search(String title, String author) throws RemoteException{
        Book[] books;
        books = dbMockup.select(title, author);
        return books;
    }

    @Override
    public void logout() throws RemoteException{
        //Remover da hashmap a sessão
        System.out.println("Logout");
    }



}

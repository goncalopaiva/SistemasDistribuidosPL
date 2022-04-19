package edu.ufp.inf.sd.rmi._04_diglib.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DigLibFactoryImpl extends UnicastRemoteObject implements DigLibFactoryRI {


    private DBMockup dbMockup;
    private HashMap<String, DigLibSessionRI> hashMap;

    public DigLibFactoryImpl() throws RemoteException {
        super();
    }

    public DigLibFactoryImpl(DBMockup dbMockup, HashMap<String, DigLibSessionRI> hashMap) throws RemoteException {
        super();
        this.dbMockup = dbMockup;
        this.hashMap = hashMap;
    }

    @Override
    public void register(String username, String password) throws RemoteException{
        dbMockup.register(username, password);
        System.out.println("Username " + username + " registered.");
    }

    @Override
    public DigLibSessionRI login(String username, String password) throws RemoteException{

        if ( !dbMockup.exists(username, password) ) {
            //Utilizador não registado  --> Criar novo utilizador
            System.out.println("Username not found. Registering new username " + username + ".");
            register(username, password);
        }

        if (!hashMap.containsKey(username)) {
            //Utilizador sem sessão  --> Criar nova sessão e inserir na hashmap
            System.out.println("Creating new session.");
            DigLibSessionRI digLibSessionRI = null;
            hashMap.put(username, digLibSessionRI);
        }

        return hashMap.get(username);

    }




}

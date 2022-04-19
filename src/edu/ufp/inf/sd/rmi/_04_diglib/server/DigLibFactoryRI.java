package edu.ufp.inf.sd.rmi._04_diglib.server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface DigLibFactoryRI extends Remote {

    /**
     *
     * @param username
     * @param password
     * @throws RemoteException
     */
    void register(String username, String password) throws RemoteException;

    /**
     *
     * @param username
     * @param password
     * @throws RemoteException
     */
    DigLibSessionRI login(String username, String password) throws RemoteException;


}

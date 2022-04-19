package edu.ufp.inf.sd.rmi._03_pingpong.client;


import edu.ufp.inf.sd.rmi._03_pingpong.server.Ball;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PongImpl extends UnicastRemoteObject implements PongRI {

    public PongImpl() throws RemoteException {
        super();
    }

    @Override
    public void pong (Ball bola) throws RemoteException {

        /*
        Remote exportObject = java.rmi.server.UnicastRemoteObject.exportObject(this, 0);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "startPlaying(): calling ping...");
        //Start game by sending ball
        pingRI.ping((PongRI) this, ball);
         */


    }

}

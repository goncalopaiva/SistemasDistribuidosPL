package edu.ufp.inf.sd.rmi._05_observer.client;

import edu.ufp.inf.sd.rmi._05_observer.server.State;
import edu.ufp.inf.sd.rmi._05_observer.server.SubjectRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObserverImpl extends UnicastRemoteObject implements ObserverRI {

   private String id;
   private edu.ufp.inf.sd.rmi._05_observer.server.State lastObserverState;
   protected SubjectRI subjectRI;
   protected edu.ufp.inf.sd.rmi._05_observer.client.ObserverGuiClient chatFrame;

    public ObserverImpl(String id, ObserverGuiClient f, SubjectRI subjectTI) throws RemoteException {
        super();
        this.id = id;
        this.subjectRI = subjectTI;
        this.chatFrame = f;
    }

    public ObserverImpl(String id, ObserverGuiClient f, String[] arg) throws RemoteException {
        super();
        this.id = id;
        this.chatFrame = f;
    }

    @Override
    public void update() {
        lastObserverState =subjectRI.getState();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public State getLastObserverState() {
        return lastObserverState;
    }

    public void setLastObserverState(State lastObserverState) {
        this.lastObserverState = lastObserverState;
    }
}

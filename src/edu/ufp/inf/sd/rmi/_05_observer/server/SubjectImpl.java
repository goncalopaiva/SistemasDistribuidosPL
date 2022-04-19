package edu.ufp.inf.sd.rmi._05_observer.server;

import edu.ufp.inf.sd.rmi._05_observer.client.ObserverRI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class SubjectImpl extends UnicastRemoteObject implements SubjectRI {

    private edu.ufp.inf.sd.rmi._05_observer.server.State subjectState;
    private ArrayList observers;

    public SubjectImpl(State subjectState) throws RemoteException {
        super();
        this.subjectState = subjectState;
    }

    public SubjectImpl() throws RemoteException {
        super();

    }

    public void notifyAllObservers() {
        for(int o=0; o<observers.size(); o++){
            ObserverRI obsRI = (ObserverRI) observers.get(o);
            //ObserverRI obsRI = (ObserverRI) observers.elementAt(o);
            obsRI.update();
        }
    }

    @Override
    public void attach(ObserverRI obsRI) {

    }

    @Override
    public void detach(ObserverRI obsRI) {

    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public void setState(State state) {
        this.subjectState = state;
    }

    public ArrayList getObservers() {
        return observers;
    }

    public void setObservers(ArrayList observers) {
        this.observers = observers;
    }
}

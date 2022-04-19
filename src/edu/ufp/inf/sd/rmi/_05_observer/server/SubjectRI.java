package edu.ufp.inf.sd.rmi._05_observer.server;

import edu.ufp.inf.sd.rmi._05_observer.client.ObserverRI;

import java.rmi.Remote;

public interface SubjectRI extends Remote {

    void attach(ObserverRI obsRI);

    void detach(ObserverRI obsRI);

    edu.ufp.inf.sd.rmi._05_observer.server.State getState();

    void setState(edu.ufp.inf.sd.rmi._05_observer.server.State state);

}

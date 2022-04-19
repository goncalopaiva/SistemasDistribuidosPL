package edu.ufp.inf.sd.rmi._02_calculator.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CalculatorImpl extends UnicastRemoteObject implements CalculatorRI {

    public CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public void print(String msg) throws RemoteException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "someone called me with msg = {0}", new Object[]{msg});
    }

    @Override
    public double add(ArrayList<Double> list) throws RemoteException {
        double sum = 0;
        for (Double l : list) {
            sum += l;
        }
        return sum;
    }

    @Override
    public double div(double a, double b) throws RemoteException {
        if (b == 0) {
            //throw new RemoteArithmeticException();
        }
        return a / b;
    }

    @Override
    public double mul(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double dif(double a, double b) throws RemoteException {
        return a - b;
    }



}
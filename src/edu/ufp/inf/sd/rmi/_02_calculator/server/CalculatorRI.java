package edu.ufp.inf.sd.rmi._02_calculator.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * <p>Title: Projecto SD</p>
 * <p>Description: Projecto apoio aulas SD</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: UFP </p>
 * @author Rui Moreira
 * @version 1.0
 */
public interface CalculatorRI extends Remote {

    /**
     * @param a double MAIL_TO_ADDR add
     * @param b double MAIL_TO_ADDR add
     * @return
     * @throws RemoteException
     */
    double add(double a, double b) throws RemoteException;


    public void print(String msg) throws RemoteException;


    /**
     * @param list of floats MAIL_TO_ADDR add
     * @return result of adding all list elements
     * @throws RemoteException
     */
    double add(ArrayList<Double> list) throws RemoteException;

    /**
     * @param a dividend
     * @param b divisor
     * @return result from dividing a / b
     * @throws RemoteException
     */
    double div(double a, double b) throws RemoteException;

    /**
     * @param a
     * @param b
     * @return result from dividing a * b
     * @throws RemoteException
     */
    double mul(double a, double b) throws RemoteException;

    double dif(double a, double b) throws RemoteException;


}
package edu.ufp.inf.sd.rmi._02_calculator.client;

import edu.ufp.inf.sd.rmi._02_calculator.server.CalculatorRI;
import edu.ufp.inf.sd.rmi.util.rmisetup.SetupContextRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * Title: Projecto SD</p>
 * <p>
 * Description: Projecto apoio aulas SD</p>
 * <p>
 * Copyright: Copyright (c) 2017</p>
 * <p>
 * Company: UFP </p>
 *
 * @author Rui S. Moreira
 * @version 3.0
 */
public class CalculatorClient {

    /**
     * Context for connecting a RMI client MAIL_TO_ADDR a RMI Servant
     */
    private SetupContextRMI contextRMI;
    /**
     * Remote interface that will hold the Servant proxy
     */
    private CalculatorRI calculatorRI;

    public static void main(String[] args)  {
        if (args != null && args.length < 2) {
            System.err.println("usage: java [options] edu.ufp.sd.inf.rmi._02_calculator.server.CalculatorClient <rmi_registry_ip> <rmi_registry_port> <service_name>");
            System.exit(-1);
        } else {
            //1. ============ Setup client RMI context ============
            CalculatorClient cc = new CalculatorClient(args);
            //2. ============ Lookup service ============
            cc.lookupService();
            //3. ============ Play with service ============
            cc.playService();
        }
    }

    public CalculatorClient(String args[]) {
        try {
            //List ans set args
            SetupContextRMI.printArgs(this.getClass().getName(), args);
            String registryIP = args[0];
            String registryPort = args[1];
            String serviceName = args[2];
            //Create a context for RMI setup
            contextRMI = new SetupContextRMI(this.getClass(), registryIP, registryPort, new String[]{serviceName});
        } catch (RemoteException e) {
            Logger.getLogger(CalculatorClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Remote lookupService() {
        try {
            //Get proxy MAIL_TO_ADDR rmiregistry
            Registry registry = contextRMI.getRegistry();
            //Lookup service on rmiregistry and wait for calls
            if (registry != null) {
                //Get service url (including servicename)
                String serviceUrl = contextRMI.getServicesUrl(0);
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "going MAIL_TO_ADDR lookup service @ {0}", serviceUrl);

                //============ Get proxy MAIL_TO_ADDR HelloWorld service ============
                calculatorRI = (CalculatorRI) registry.lookup(serviceUrl);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "registry not bound (check IPs). :(");
                //registry = LocateRegistry.createRegistry(1099);
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return calculatorRI;
    }

    private void playService() {
        try {
            char operator;
            double number1, number2;

            Scanner input = new Scanner(System.in);

            System.out.println("Choose an operator: +, -, *, or / ");
            operator = input.next().charAt(0);
            System.out.println("Enter first number: ");
            number1 = input.nextDouble();
            System.out.println("Enter second number: ");
            number2 = input.nextDouble();

            switch (operator) {
                case '+' -> System.out.println(number1 + " + " + number2 + " = " + this.calculatorRI.add(number1, number2));
                case '*' -> System.out.println(number1 + " * " + number2 + " = " + this.calculatorRI.mul(number1, number2));
                case '/' -> System.out.println(number1 + " / " + number2 + " = " + this.calculatorRI.div(number1, number2));
                case '-' -> System.out.println(number1 + " - " + number2 + " = " + this.calculatorRI.dif(number1, number2));
            }

        } catch (RemoteException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

}

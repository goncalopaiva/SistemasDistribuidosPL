package edu.ufp.inf.sd.rmi._06_visitor.server;

import java.rmi.RemoteException;

public class VisitorFoldersOperationDeleteFile implements VisitorFoldersOperationsI{

    private String fileToDelete;
    private String fileToDeleteWithPrefix;

    public VisitorFoldersOperationDeleteFile(String s) {
        setFileToDelete(s);
    }

    @Override
    public Object visitConcreteElementStateBooks(ElementFolderRI element) throws RemoteException {
        ((ConcreteElementFolderBooksImpl)element).getStateBooksFolder().createFile(this.fileToDelete);
        return element;
    }

    /*@Override
    public Object visitConcreteElementStateMagazines(ElementFolderRI element) {

    } */

    public String getFileToDelete() {
        return fileToDelete;
    }

    public void setFileToDelete(String fileToDelete) {
        this.fileToDelete = fileToDelete;
    }

}

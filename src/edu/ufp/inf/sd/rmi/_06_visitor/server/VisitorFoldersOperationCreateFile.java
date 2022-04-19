package edu.ufp.inf.sd.rmi._06_visitor.server;

import java.rmi.RemoteException;

public class VisitorFoldersOperationCreateFile implements VisitorFoldersOperationsI{

    private String fileToCreate;
    private String fileToCreateWithPrefix;

    public VisitorFoldersOperationCreateFile(String newFolder) {
        SingletonFolderOperationsBooks.createSingletonFolderOperationsBooks(newFolder);
    }

    @Override
    public Object visitConcreteElementStateBooks(ElementFolderRI element) throws RemoteException {
        ((ConcreteElementFolderBooksImpl)element).getStateBooksFolder().createFile(this.fileToCreate);
        return element;
    }

    /*@Override
    public Object visitConcreteElementStateMagazines(ElementFolderRI element) {

    } */

    public String getFileToCreate() {
        return fileToCreate;
    }

    public void setFileToCreate(String fileToDelete) {
        this.fileToCreate = fileToDelete;
    }

}

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CaixaInterface extends Remote {
    void depositar(String nome, double valor) throws RemoteException;
    void sacar(String nome, double valor) throws RemoteException;
    double consultarSaldo(String nome) throws RemoteException;
}

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CaixaInterface extends Remote {
    void depositar(Conta conta, double valor) throws RemoteException;
    void sacar(Conta conta, double valor) throws RemoteException;
    double consultarSaldo(Conta conta) throws RemoteException;
}

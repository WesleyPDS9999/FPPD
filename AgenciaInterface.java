import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AgenciaInterface extends Remote {
    boolean solicitaAbrirConta(String nome, int nroConta) throws RemoteException;
    boolean solicitaFecharConta(Conta conta) throws RemoteException;
    boolean autenticarConta(Conta conta) throws RemoteException;
    void depositar(Conta conta, double valor) throws RemoteException;
    void sacar(Conta conta, double valor) throws RemoteException;
    double consultarSaldo(Conta conta) throws RemoteException;
}

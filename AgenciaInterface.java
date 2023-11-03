import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AgenciaInterface extends Remote {
    boolean solicitaAbrirConta(String nome, int nroConta) throws RemoteException;
    boolean solicitaFecharConta(String nome) throws RemoteException;
    boolean autenticarConta(Conta conta) throws RemoteException;
    void depositar(String nome, double valor) throws RemoteException;
    void sacar(String nome, double valor) throws RemoteException;
    double consultarSaldo(String nome) throws RemoteException;
}

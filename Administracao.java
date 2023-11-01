import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Administracao extends UnicastRemoteObject implements AgenciaInterface, CaixaInterface
{
    private ArrayList<Conta> contas;

    public Administracao() {
        contas = new ArrayList<>();
        contas.add(new Conta(100, "Mateus"));
        contas.add(new Conta(200, "Jorge"));
        contas.add(new Conta(300, "Gabriel"));
    }

    public void sacar(Conta conta, double valor) {
        if (conta != null) {
            if (conta.getSaldo() > valor) { 
                conta.setSaldo(conta.getSaldo() - valor);
            }
        }
    }

    public void depositar(Conta conta, double valor) {
        if (conta != null) {
            conta.setSaldo(conta.getSaldo() + valor);        
        }
    }

    public boolean autenticarConta(Conta conta) {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).equals(conta.getNome()) && contas.get(i).equals(conta.getNroConta())) {
                return true;
            }
        }
        return false;
    }

    public boolean solicitaAbrirConta(String nome, int nroConta) {
        if (contas.add(new Conta(nroConta, nome))) return true;
        return false;
    }

    public boolean solicitaFecharConta(Conta conta) {
        if (autenticarConta(conta)) {
            contas.remove(conta);
            return true;
        }

        return false;
    }

    public double consultarSaldo(Conta conta) {
        return conta.getSaldo();
    }

}

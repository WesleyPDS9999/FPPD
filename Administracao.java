import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

class Conta 
{
    public int nroConta;
    public String nome;
    public double saldo;

    public Conta(int nroConta, String nome) {
        this.nome = nome;
        this.nroConta = nroConta;
        this.saldo = 0;
    }

    public String getNome(){
        return this.nome;
    }

    public int getNroConta(){
        return this.nroConta;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double valor) {
        this.saldo = valor;
    }
}

public class Administracao extends UnicastRemoteObject implements AgenciaInterface, CaixaInterface
{
    private ArrayList<Conta> contas;

    public Administracao() throws RemoteException{
        this.contas = new ArrayList<>();
                contas.add(new Conta(000,"Wesley"));
                contas.add(new Conta(001,"Lucca"));
                contas.add(new Conta(002,"Erik"));
                contas.add(new Conta(003,"Gabriel"));
    }

    public void sacar(String nome, double valor) throws RemoteException {
        for(int i = 0; i < contas.size(); i++){
            if (contas.get(i).nome.equals(nome)) {
                if(valor < contas.get(i).getSaldo()){
                    contas.get(i).setSaldo(contas.get(i).getSaldo() - valor);
                }
            }
        }
    }

    public void depositar(String nome, double valor) throws RemoteException {
        for(int i = 0; i < contas.size(); i++){
            if (contas.get(i).nome.equals(nome)) {
                contas.get(i).setSaldo(contas.get(i).getSaldo()+ valor);
            }
        }
    }

    public boolean autenticarConta(String nome, int nConta) throws RemoteException {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).nome.equals(nome) && contas.get(i).nroConta == nConta) {
                return true;
            }
        }
        return false;
    }

    public boolean solicitaAbrirConta(String nome, int nroConta) throws RemoteException {
        contas.add(new Conta(nroConta, nome));
        return true;
    }

    public boolean solicitaFecharConta(String nome) throws RemoteException {
        for(int i = 0; i < contas.size(); i++){
            if (contas.get(i).nome.equals(nome)) {
                contas.remove(contas.get(i));
                return true;
            }
        }
        return false;
    }

    public double consultarSaldo(String nome) throws RemoteException {
        for(int i = 0; i < contas.size(); i++){
            if (contas.get(i).nome.equals(nome)) {
                return contas.get(i).getSaldo();
            }
        }
        return -1;
    }

}

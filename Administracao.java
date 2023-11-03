import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
    private Conta[] contas;

    public Administracao() throws RemoteException{
        this.contas = new Conta[]{
                new Conta(000,"Wesley"),
                new Conta(001,"Lucca"),
                new Conta(002,"Erik"),
                new Conta(003,"Gabriel")
        };
    }

    public void sacar(String nome, double valor) {
        for(int i = 0; i < contas.length; i++){
            if (contas[i].getNome() == nome) {
                if(valor < contas[i].getSaldo()){
                    contas[i].setSaldo(contas[i].getSaldo() - valor);
                }
            }
        }
    }

    public void depositar(String nome, double valor) {
        for(int i = 0; i < contas.length; i++){
            if (contas[i].getNome() == nome) {
                contas[i].setSaldo(contas[i].getSaldo()+ valor);
            }
        }
    }

    public boolean autenticarConta(Conta conta) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i].equals(conta.getNome()) && contas[i].equals(conta.getNroConta())) {
                return true;
            }
        }
        return false;
    }

    public boolean solicitaAbrirConta(String nome, int nroConta) {
        new Conta(nroConta, nome);
        return true;
    }

    public boolean solicitaFecharConta(String nome) {
        for(int i = 0; i < contas.length; i++){
            if (contas[i].getNome() == nome) {
                contas[i] = null;
                return true;
            }
        }
        return false;
    }

    public double consultarSaldo(String n) throws RemoteException {
        for(int i = 0; i < contas.length; i++){
            if (contas[i].nome.equals(n)) {
                return contas[i].getSaldo();
            }
        }
        return -1;
    }

}

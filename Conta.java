public class Conta 
{
    private int nroConta;
    private String nome;
    private double saldo;

    public Conta(int nroConta, String nome) {
        nome = nome;
        nroConta = nroConta;
        saldo = 0.0;
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
        saldo = valor;
    }
    
}

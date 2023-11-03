import java.rmi.Naming;

public class AgenciaClient {
	public static void main (String[] args) {
		double saldo;

		if	(args.length != 2)  {
			System.out.println("Uso: java AgenciaClient <maquina> <nome>");
			System.exit(1);
		}
		try {
			AgenciaInterface conta = (AgenciaInterface) Naming.lookup ("//"+args[0]+"/Agencias");
			saldo = conta.consultarSaldo(args[1]);
			System.out.println ("Nome: "+ args[1]);
			if (saldo<-1.0)
				System.out.println ("Resultado: nome nao encontrado!\n");
			else
				System.out.println ("Saldo: " + saldo);
		} catch (Exception e) {
			System.out.println ("AgenciaClient failed.");
			e.printStackTrace();
		}
	}
}


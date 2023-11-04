import java.rmi.Naming;
import java.util.Scanner;
import java.util.InputMismatchException;

public class AgenciaClient {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		if	(args.length != 1)  {
			System.out.println("Uso: java AgenciaClient <maquina>");
			System.exit(1);
		}
		try {
			AgenciaInterface conta = (AgenciaInterface) Naming.lookup ("//"+args[0]+"/Agencias");
			while (true)    {
				System.out.println("\n----------");
				System.out.println("-- MENU --");
				System.out.println("----------\n");
				System.out.println("1. Abrir uma nova conta.");
				System.out.println("2. Autenticar.");
				System.out.println("3. Consultar seu saldo.");
				System.out.println("4. Sacar.");
				System.out.println("5. Depositar.");
				System.out.println("6. Fechar conta.");
				System.out.println("7. Finalizar o programa.");
				System.out.println("Escolha sua opcao.");
				try {
					int op = sc.nextInt();
					switch (op) {
						case 1:
							System.out.println("\nInforme seu nome:");
							String nome = sc.next();
							System.out.println("\nInforme um número de identificação para sua nova conta:");
							int nroConta = sc.nextInt();
							conta.solicitaAbrirConta(nome,nroConta);
							System.out.println("\nConta aberta com sucesso.");
							break;
						case 2:
							System.out.println("\nInforme seu nome:");
							String n = sc.next();
							System.out.println("\nInforme um número de identificação da sua conta:");
							int nConta = sc.nextInt();
							if(conta.autenticarConta(n, nConta)){
								System.out.println("\nConta autenticada com sucesso.");
							}else{
								System.out.println("\nConta inválida.");
							}
							break;
						case 3:
							System.out.println("\nInforme seu nome:");
							String n2 = sc.next();
							if(conta.consultarSaldo(n2) == -1){
								System.out.println("\nConta inválida");
							}else{
								System.out.printf("%nSeu saldo é de: R$ %.2f %n" , conta.consultarSaldo(n2));
							}
							break;
						case 4:
							System.out.println("\nInforme seu nome:");
							String n3 = sc.next();
							if(conta.consultarSaldo(n3) == -1){
								System.out.println("\nConta inválida");
							}else{
								System.out.println("\nInforme o valor desejado para o saque:");
								double valor = sc.nextDouble();
								if(conta.consultarSaldo(n3) >= valor){
									conta.sacar(n3, valor);
									System.out.println("\nSaque concluído com sucesso.");
								}else{
									System.out.println("Saldo insuficiente.");
								}
							}
							break;
						case 5:
							System.out.println("\nInforme seu nome:");
							String n4 = sc.next();
							if(conta.consultarSaldo(n4) == -1){
								System.out.println("\nConta inválida");
							}else{
								System.out.println("\nInforme o valor desejado para o deposito:");
								double valor1 = sc.nextDouble();
								conta.depositar(n4, valor1);
								System.out.println("\nDepósito concluído com sucesso.");
							}
							break;
						case 6:
							System.out.println("\nInforme seu nome:");
							String n5 = sc.next();
							conta.solicitaFecharConta(n5);
							if(conta.solicitaFecharConta(n5) == false){
								System.out.println("\nConta inválida");
							}else{
								System.out.println("\nConta encerrada com sucesso.");
							}
							break;
						case 7:
							sc.close();
							System.out.println("Finalizando Programa....");
							System.exit(0);
							break;
						default:
							System.out.println("Escolha uma opção válida");
					}
				}
				catch (InputMismatchException e) {
					System.out.println("Insira uma entrada válida");
					sc.next();
				}
	
			}
		} catch (Exception e) {
			System.out.println ("AgenciaClient failed.");
			e.printStackTrace();
		}
	}
}


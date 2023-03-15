package Program;

import java.util.Scanner;
import java.util.ArrayList;

public class AgenciaBancaria {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("---------Bem vindos a nossa Ag�ncia-----------------------------");
		System.out.println("----------------------------------------------------------------");
		System.out.println("****** Selecione uma opera��o que deseja realizar---------------");
		System.out.println("----------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------");
		System.out.println("|    Opc�o 1 - Criar Conta    |");
		System.out.println("|    Opc�o 2 - Depositar      |");
		System.out.println("|    Opc�o 3 - Sacar          |");
		System.out.println("|    Opc�o 4 - Transferir     |");
		System.out.println("|    Opc�o 5 - Lista          |");
		System.out.println("|    Opc�o 6 - Sair           |");

		int operacao = sc.nextInt();
		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("flw eh nois, obrigado por usar nossa agencia!");
			System.exit(0);
		default:
			System.out.println("Op��o invalida!");
			operacoes();
			break;

		}

	}

	public static void criarConta() {

		System.out.println("\nNome: ");
		String nome = sc.next();
		sc.nextLine();
		System.out.println("\nCPF: ");
		String cpf = sc.next();
		System.out.println("\nEmail: ");
		String email = sc.next();
		
		Pessoa pessoa1 = new Pessoa(nome, cpf, email);

		Conta conta1 = new Conta(pessoa1);

		contasBancarias.add(conta1);
		System.out.println("Sua conta foi criada com sucesso!");

		operacoes();

	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta)
					;
				conta = c;
			}
		}
		return conta;
	}

	public static void depositar() {
		System.out.println("Numero da conta: ");
		int numeroConta = sc.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual valor deseja depositar? ");
			Double valorDeposito = sc.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println(" Valor depositado com sucesso!");
		} else {
			System.out.println(" Transa��o n�o efetuada.  ");
		}
		operacoes();
	}

	public static void sacar() {
		System.out.println("Numero da conta: ");
		int numeroConta = sc.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual valor deseja sacar? ");
			Double valorSaque = sc.nextDouble();
			conta.sacar(valorSaque);
		} else {
			System.out.println(" Valor para saque inv�lido.  ");
		}
		operacoes();

	}

	public static void transferir() {
		System.out.println("N�mero da conta do remetente: ");
		int numeroContaRemetente = sc.nextInt();

		Conta contaRemetente = encontrarConta(numeroContaRemetente);

		if (contaRemetente != null) {
			
			System.out.println("N�mero da conta do destinat�rio: ");
			int numeroContaDestinatario = sc.nextInt();

			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if (contaDestinatario != null) {
				
				System.out.println("Valor da transfer�ncia: ");
				Double valor = sc.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);

			}

		}
		operacoes();
	}
	public static void listarContas() {
		if (contasBancarias.size() > 0){
			for(Conta conta: contasBancarias) {
				System.out.println(conta);
			}
			}else {
				System.out.println("N�o h� contras cadastradas! ");
		}
		operacoes();
	}
	
}


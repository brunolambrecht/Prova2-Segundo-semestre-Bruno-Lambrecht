package br.edu.univas.main;

import java.util.Scanner;

public class StartApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Dados[] contas = new Dados[100];
		String operation;
		do {
			menu();
			operation = sc.nextLine();
			if (operation.equals("1")) {
				registerAccount(contas);
			} else if (operation.equals("2")) {
				balance(contas);
			} else if (operation.equals("3")) {
				break;
			} else {

			}
		} while (true);
		sc.close();
	}

	public static void registerAccount(Dados[] contas) {
		int i = 0;
		do {
			if (contas[i] == null) {
				Dados account = new Dados();
				System.out.println("\n Cadastro de Conta: ");
				System.out.println("Digite a descrição desta conta: ");
				account.descricao = sc.nextLine();
				System.out.println("Digite o valor da conta: ");
				account.valor = sc.nextFloat();
				sc.nextLine();
				System.out.println("Digite a data de vencimento: ");
				account.dataVenc = sc.nextLine();
				System.out.println("Digite o tipo de conta: Despesa ou Receita.");
				account.tipo = sc.nextLine();
				contas[i] = account;
				break;
			}
			i++;
		} while (true);
	}

	public static void balance(Dados[] contas) {
		float receita = 0;
		float despesa = 0;
		for (int i = 0; i < 100; i++) {
			if (contas[i] != null) {
				Dados conta = contas[i];
				if (conta.tipo.equals("Despesa")) {
					despesa = conta.valor + despesa;
				} else if (conta.tipo.equals("Receita")) {
					receita = conta.valor + receita;
				} else {

				}
			}
		}
		float balance = receita - despesa;
		if (balance > 0) {
			System.out.printf("\n Saldo Positivo: %.2f %n", balance);
		} else if (balance < 0) {
			System.out.printf("\n Saldo Negativo: %.2f %n", balance);
		} else {
			System.out.println("\n Saldo Zerado!");
		}
	}

	public static void menu() {
		System.out.println("  Controle de contas   \n");
		System.out.println("1 - Cadastro de conta");
		System.out.println("2 - Ver Saldo ");
		System.out.println("3 - Sair");
	}
}
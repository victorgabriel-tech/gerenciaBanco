package com.mycompany.gerenciabanco;

import java.util.Scanner;

public class GerenciaBanco {

    public static void exibirMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();

        System.out.print("Digite seu nome: ");
        conta.nome = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        conta.sobrenome = scanner.next();

        System.out.print("Digite seu CPF: ");
        conta.cpf = scanner.next();

        System.out.println("\nBem-vindo(a), " + conta.nome + " " + conta.sobrenome + "!");

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor para depósito: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para saque: R$ ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 4:
                    System.out.println("\nAté logo, " + conta.nome + "! Obrigado por usar o GerenciaBanco.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
    }
}

class ContaBancaria {
    String nome;
    String sobrenome;
    String cpf;
    double saldo = 0;

    public void consultarSaldo() {
        System.out.println("\nSeu saldo atual é: R$ " + saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else if (valor <= 0) {
            System.out.println("Valor inválido para saque!");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        }
    }
}
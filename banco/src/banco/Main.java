package banco;

import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double saldo = 2500.00;
        int cod;

        System.out.println("------------------------");
        System.out.println("Bem vindo ao banco!");
        
        do {
            exibirMenu();
            cod = sc.nextInt();

            switch (cod) {
                case 1:
                    mostrarSaldo(saldo);
                    break;
                case 2:
                    saldo = transferencia(saldo, sc);
                    break;
                case 3:
                    saldo = deposito(saldo, sc);
                    break;
                case 4:
                    System.out.println("Obrigado por usar o banco!");
                    break;
                default:
                    System.out.println("Código inválido, tente novamente.");
            }
        } while (cod != 4);

        sc.close();
    }

    public static void mostrarSaldo(double saldo) {
        System.out.printf("Seu saldo é: R$%.2f%n", saldo);
    }

    public static double transferencia(double saldo, Scanner sc) {
        System.out.println("Qual o valor da sua transferência?");
        System.out.print("R$: ");
        double valorTransf = sc.nextDouble();
        if (valorTransf > 0) {
            if (valorTransf <= saldo) {
                saldo -= valorTransf;
                System.out.println("Transferência realizada.");
            } else {
                System.out.println("Saldo insuficiente para realizar a transferência.");
            }
        } else {
            System.out.println("Valor inválido. A transferência deve ser maior que zero.");
        }
        mostrarSaldo(saldo);
        return saldo;
    }

    public static double deposito(double saldo, Scanner sc) {
        System.out.println("Qual o valor do seu depósito?");
        System.out.print("R$: ");
        double valorDepo = sc.nextDouble();
        if (valorDepo > 0) {
            saldo += valorDepo;
            System.out.println("Depósito realizado.");
        } else {
            System.out.println("Valor inválido. O depósito deve ser maior que zero.");
        }
        mostrarSaldo(saldo);
        return saldo;
    }

    public static void exibirMenu() {
        System.out.println();
        System.out.println("------------------------");
        System.out.println("Como podemos te ajudar?");
        System.out.println("1 - Mostrar saldo");
        System.out.println("2 - Transferência Bancária");
        System.out.println("3 - Depósito Bancário");
        System.out.println("4 - Sair");
        System.out.println("------------------------");
        System.out.println();
    }
}

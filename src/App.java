package src;

import src.model.ContaCorrente;
import src.model.ContaPoupança;

public class App {

    public static void main(String[] args) {

        System.out.println("Criando nosso banco Digital");
        System.out.println();

        ContaCorrente conta = new ContaCorrente("001", "7542", 5, 100.00);
        System.out.println("Saldo atual é de R$" + conta.getSaldo());
        System.out.println();

        conta.depositar(250.0);
        System.out.println("Saldo atual é de R$" + conta.getSaldo());
        System.out.println();

        conta.sacar(150.0);
        System.out.println("Saldo atual é de R$" + conta.getSaldo());
        System.out.println();

        ContaPoupança conta2 = new ContaPoupança("0001", "7543", 6, 200.0);
        conta2.transferir(100.0, conta);
        System.out.println("Saldo atual é de R$" + conta2.getSaldo());
        System.out.println();

        System.out.println("Saldo atual é de R$" + conta.getSaldo());
        System.out.println(conta2.getDataAbertura());

        // Aqui um exemplo de metodos não abstratos, precisa instanciar uma classe para
        // ter acesso aos seus metodos
        /*
         * DataUtil util = new DataUtil();
         * var formatado = util.converterDateParaDataeHora(conta2.getDataAbertura());
         * System.out.println(formatado);
         */

        // Esse é um exemplo de metodos abstrato
        // var f1 = DataUtil.converterDateParaDataeHora(conta2.getDataAbertura());

        conta2.imrimirExtrato();
        System.out.println();

        conta.imrimirExtrato();

    }
}

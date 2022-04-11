package src.model;

import java.util.Date;

import src.utils.DataUtil;

public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(String agencia, String conta, Integer digito, double saldo) {
        super(agencia, conta, digito, saldo);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void imrimirExtrato() {
        // TODO Auto-generated method stub

        System.out.println("*******************************");
        System.out.println("*******Extrato Bancario *******");
        System.out.println("*******************************");
        System.out.println();

        System.out.println("Gerado em: " + DataUtil.converterDateParaDataeHora(new Date()));
        System.out.println();

        for (Movimentacao movimentacao : this.movimentacoes) {
            System.out.println(movimentacao);
            System.out.println();
        }
        System.out.println();
        System.out.println("*******************************");
        System.out.println("*******************************");
        System.out.println("*******************************");

    }

}

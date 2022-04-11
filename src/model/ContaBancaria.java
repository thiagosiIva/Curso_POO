package src.model;

import java.util.InputMismatchException;
import java.util.*;

//Uma classe abstrata serve de modelo, não consegue ser instanciada 
public abstract class ContaBancaria {

    // #region Atributos
    protected String agencia;
    protected String conta;
    protected Integer digito;
    protected double saldo;
    protected double VALOR_MINIMO_DEPOSITO = 10.0;
    protected Date dataAbertura;
    protected ArrayList<Movimentacao> movimentacoes; // Precisa nstanciar esse array
    // #endregion

    // #region Construtor
    public ContaBancaria(String agencia, String conta, Integer digito, double saldo) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.saldo = saldo;
        this.dataAbertura = new Date();
        // Se não instanciar o array, vai dar uma exception de nullPointerException
        this.movimentacoes = new ArrayList<Movimentacao>();
        // Criando a primeira movimetação
        Movimentacao movimentacao = new Movimentacao("Abertura de conta", saldo);
        // Aqui estou salvando a movimentação dentro do mmeu array de movimentação
        this.movimentacoes.add(movimentacao);

    }
    // #endregion

    // #region Gettrs e setters

    public String getAgencia() {
        return agencia;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public double getVALOR_MINIMO_DEPOSITO() {
        return VALOR_MINIMO_DEPOSITO;
    }

    public void setVALOR_MINIMO_DEPOSITO(double vALOR_MINIMO_DEPOSITO) {
        VALOR_MINIMO_DEPOSITO = vALOR_MINIMO_DEPOSITO;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public double getSaldo() {
        return saldo;
    }
    // #endregion

    // #region metodos
    public void depositar(Double valor) {
        // Compara se o valo minimo para depósito, se fo menor que 10 reais, uma
        // mensagem é exibida ao usuário
        if (valor < VALOR_MINIMO_DEPOSITO) {
            throw new InputMismatchException("O valor minimo de deposito é R$" + VALOR_MINIMO_DEPOSITO);
        }
        // Soma o saldo atual com o valor de deposito
        this.saldo += valor;

        // Aqui faço uma movimentação no extrato
        Movimentacao movimentacao = new Movimentacao("Deposito", valor);
        this.movimentacoes.add(movimentacao);
    }

    public double sacar(Double valor) {
        // Verifica se o valor que o usuário quer sacar é maior d que o saldo que ele
        // tem na conta, caso isso aconteça, uma mensagem é exibida na tela
        if (valor > this.saldo) {
            throw new InputMismatchException("O valor é insuficiente");
        }
        // Remove o saldo do saque na variavel valor
        this.saldo -= valor;
        // Aqui faço uma movimentação no extrato
        Movimentacao movimentacao = new Movimentacao("Retirada de valor", valor);
        this.movimentacoes.add(movimentacao);

        return valor;
    }

    public void transferir(Double valor, ContaBancaria contaDestino) {
        // Efetua um saque na conta atual
        this.sacar(valor);
        // Efetua um depsito na conta Destino
        contaDestino.depositar(valor);

    }

    // Um metodo abstrato não tem implementação, quem herdar dessa classe tera que
    // que implementar a logica
    public abstract void imrimirExtrato();
    // #endregion

}

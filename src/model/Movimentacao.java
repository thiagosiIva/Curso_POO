package src.model;

import java.util.Date;

import src.utils.DataUtil;

public class Movimentacao {

    private String descricao;
    private Date data;
    private double valor;

    public Movimentacao(String descricao, double valor) {
        this.descricao = descricao;
        this.data = new Date();
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        String dataFormatada = DataUtil.converterDateParaDataeHora(this.getData());
        return this.getDescricao() + " - " + dataFormatada + " - R$" + this.valor;

    }

}

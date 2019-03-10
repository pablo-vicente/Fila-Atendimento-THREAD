/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pablo
 */
public class Prioridade {
    private int cod;
    private Prioridade prioridade;
    private Cidadao cidadao;
    private int qntAtendidoSequen;

    public Prioridade(int cod){
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }

    public int getQntAtendidoSequen() {
        return qntAtendidoSequen;
    }

    public void setQntAtendidoSequen(int qntAtendidoSqn) {
        this.qntAtendidoSequen = qntAtendidoSqn;
    }

 }

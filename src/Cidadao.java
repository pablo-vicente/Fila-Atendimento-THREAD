import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pablo
 */
public class Cidadao extends Thread{
    private String id;
    private int tempoAtendimento;
    private Cidadao cidadao;
    private boolean promovido;

    public Cidadao(int tempoAtendimento) {
        this.tempoAtendimento = tempoAtendimento;
        this.id = gerarID();
    }

    public int getTempoAtendimento() {
        return tempoAtendimento;
    }

    public void setTempoAtendimento(int tempoAtendimento) {
        this.tempoAtendimento = tempoAtendimento;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }

    public boolean isPromovido() {
        return promovido;
    }

    public void setPromovido(boolean promovido) {
        this.promovido = promovido;
    }

    public String getIdCidadao() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    private String gerarID(){
        String idCdado = "";
        
        Random random = new Random();
        String letra1 = getLetra(random.nextInt(26));
        String letra2 = getLetra(random.nextInt(26));
        String letra3 = getLetra(random.nextInt(26));
        
        int n1 = random.nextInt(10);
        int n2 = random.nextInt(10);
        int n3 = random.nextInt(10);
        int n4 = random.nextInt(10);
        
        idCdado = letra1+letra2+letra3+"-"+n1+n2+n3+n4;
        return idCdado;
    }
    
    private String getLetra(int codLetra){
        String letra = "-";
        
        switch(codLetra){
            case 0:
                letra = "A";
                break;
            case 1:
                letra = "B";
                break;
            case 2:
                letra = "C";
                break;
            case 3:
                letra = "D";
                break;
            case 4:
                letra = "E";
                break;
            case 5:
                letra = "F";
                break;
            case 6:
                letra = "G";
                break;
            case 7:
                letra = "H";
                break;
            case 8:
                letra = "I";
                break;
            case 9:
                letra = "J";
                break;
            case 10:
                letra = "K";
                break;
            case 11:
                letra = "L";
                break;
            case 12:
                letra = "M";
                break;
            case 13:
                letra = "N";
                break;
            case 14:
                letra = "O";
                break;
            case 15:
                letra = "P";
                break;
            case 16:
                letra = "Q";
                break;
            case 17:
                letra = "R";
                break;
            case 18:
                letra = "S";
                break;
            case 19:
                letra = "T";
                break;
            case 20:
                letra = "U";
                break;
            case 21:
                letra = "V";
                break;
            case 22:
                letra = "W";
                break;
            case 23:
                letra = "X";
                break;
            case 24:
                letra = "Y";
                break;
            case 25:
                letra = "Z";
                break;    
        }
        return letra;
    }
    
}

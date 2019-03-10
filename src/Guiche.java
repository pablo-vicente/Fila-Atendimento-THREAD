/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pablo
 */
public class Guiche implements Runnable{
    private Thread thread = null;
    private String codGuiche;
    private FilaAtendimento filaAtendimento;
    
    public Guiche(String codGuiche,FilaAtendimento filaAtendimento){
        this.codGuiche = codGuiche.toUpperCase();
        this.filaAtendimento = filaAtendimento;
        if (thread == null) {
            thread = new Thread(this, codGuiche);
            
        }
    }
    
    public void start() {
        thread.start();
    }

    
    public void run() {
        try{
            int pause = 2000;
            Thread.sleep(10000);
            System.out.println("\n[============== INICIANDO ATENDIMENTO "+codGuiche+"================]");
            
            while(true){
                //synchronized(this){
                    // System.out.println(filaAtendimento.exibirFila());
                    System.out.println(codGuiche+": Próximo cidadao....");
                    Cidadao cidadao = filaAtendimento.atenderCidadao();
                    Thread.sleep(cidadao.getTempoAtendimento()*1000);
                    System.out.println(codGuiche+": Atendeu cidadao ID: : "+cidadao.getIdCidadao()+" atendido em: "+cidadao.getTempoAtendimento()+"s");
                    Thread.sleep(2000);
                    System.out.println(filaAtendimento.exibirFila());
                    Thread.sleep(2000);
                    //filaAtendimento.notifyAll();
                //}
            }
            
        } catch (NullPointerException e){
            System.out.println("\n[=============== "+codGuiche+" TERMINOU ATENDIMENTO ===============]");
            Trabalho2SO.filaVazia = true;
        } catch (InterruptedException ex) {
            System.out.println("Deu merda");
        }
    }
}

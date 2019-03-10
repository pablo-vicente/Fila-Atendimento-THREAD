/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Pablo Vicente
 */
public class Trabalho2SO {
    
    /**
     * @param args the command line arguments
     */
    private static FilaAtendimento filaAtendimento;
    public static boolean filaVazia = false;
    
    public static void main(String[] args) {
        System.out.println("[=================== GERENCIAMENTO DE FILAS ====================]");
        System.out.print("Digite a quantidade de guichês: ");
        int qntGuiches = pedirInteiro();
        System.out.print("Digite a quantidade de cidadãos: ");
        filaAtendimento = new FilaAtendimento();
        //teste();
        
        if(filaAtendimento.isListaVazia()){
            new Thread(createCidadao).start();
        }
        for(int i = 1;i<=qntGuiches;i++){
            new Guiche("Guiche "+i, filaAtendimento).start();
        }
    }
    
    
    private static Runnable createCidadao = new Runnable() {
        @Override
        public void run() {
            try{
                synchronized(this){
                    int contador = 0;
                    Random randon = new Random();
                    int qntCidadaos = pedirInteiro();
                    while (!Trabalho2SO.filaVazia && contador<qntCidadaos){
                        int prioridade = randon.nextInt(3);//Cria prioridade
                        int tempoAtendimento = randon.nextInt(9)+1; // cria tempo de atendimento
                        Cidadao cidadao = new Cidadao(tempoAtendimento);//Cria cidadao
                        if(Trabalho2SO.filaVazia) {
                            System.out.println("Opa, cidadao chegou bem na hora que fechou!");
                        } else {
                            filaAtendimento.inserirCidadao(cidadao, prioridade);
                            contador++;
                            System.out.println("Cidadao entrou na fila ID: "+cidadao.getIdCidadao()+" | Prioridade: "+prioridade);
                            Thread.sleep(1000);
                            System.out.println(filaAtendimento.exibirFila());
                            Thread.sleep(1000/2);
                            }
                    }
                }
            } catch (Exception e){}
 
        }
    };
    
    public static int pedirInteiro(){
        Scanner sc = new Scanner(System.in);
        boolean repetir;
        int numero=-1;
        do {
            repetir = false;
                try {
                    numero = sc.nextInt();
                    if(numero<=0){
                        repetir = true;
                        sc.nextLine();
                        System.out.println("Digite número inteiro positivo!");
                    }
                } catch(InputMismatchException e) {
                    repetir = true;
                    sc.nextLine();
                    System.out.println("Seu burro digite somente números\n");
                }
        } while(repetir);
        return numero;
    }
    
    /*
    private static Runnable atenderCidado = new Runnable(){
        @Override
        public void run() {
            try{
                synchronized(this){
                    int pause = 2000;
                    Thread.sleep(10000);
                    System.out.println("\n[=================== INICIANDO ATENDIMENTO =====================]");
                    while(true){
                        System.out.println("Próximo cidadao....");
                        Cidadao cidadao = filaAtendimento.atenderCidadao();
                        Thread.sleep(cidadao.getTempoAtendimento());
                        System.out.println("Atendendo cidadao ID: : "+cidadao.getIdCidadao()+" atendido em: "+cidadao.getTempoAtendimento()+"s");
                        Thread.sleep(pause);
                        System.out.println(filaAtendimento.exibirFila());
                        Thread.sleep(cidadao.getTempoAtendimento()/2);
                    }
                }
            } catch (java.lang.NullPointerException e){
                System.out.println("\n[==================== TERMINOU ATENDIMENTO =====================]");
                Trabalho2SO.filaVazia = true;
            } catch (InterruptedException ex) {
                System.out.println("Deu merda");
            }
        }
    };
        */
    


/*
    public static void teste(){
        //FilaAtendimento filaAtendimento = new FilaAtendimento();
        Cidadao c1 = new Cidadao(5);
        Cidadao c2 = new Cidadao(6);
        Cidadao c3 = new Cidadao(7);
        Cidadao c4 = new Cidadao(8);
        Cidadao c5 = new Cidadao(8);
        Cidadao c6 = new Cidadao(8);
        Cidadao c7 = new Cidadao(8);
        Cidadao c8 = new Cidadao(8);
        Cidadao c9 = new Cidadao(8);
        Cidadao c10 = new Cidadao(8);
        Cidadao c11 = new Cidadao(8);
        Cidadao c12 = new Cidadao(8);
        Cidadao c13 = new Cidadao(8);
        Cidadao c14 = new Cidadao(8);
        Cidadao c15 = new Cidadao(8);
        Cidadao c16 = new Cidadao(8);
        Cidadao c17 = new Cidadao(8);
        Cidadao c18 = new Cidadao(8);
        Cidadao c19 = new Cidadao(8);
        Cidadao c20 = new Cidadao(8);
        Cidadao c21 = new Cidadao(8);
        Cidadao c22 = new Cidadao(8);
        Cidadao c23 = new Cidadao(8);
        Cidadao c24 = new Cidadao(8);
        Cidadao c25 = new Cidadao(8);
        Cidadao c26 = new Cidadao(8);
        Cidadao c27 = new Cidadao(8);
        Cidadao c28 = new Cidadao(8);
        Cidadao c29 = new Cidadao(8);
        Cidadao c30 = new Cidadao(8);
        Cidadao c31 = new Cidadao(8);
        Cidadao c32 = new Cidadao(8);
        Cidadao c33 = new Cidadao(8);
        Cidadao c34 = new Cidadao(8);
        Cidadao c35 = new Cidadao(8);
        Cidadao c36 = new Cidadao(8);
        Cidadao c37 = new Cidadao(8);
        Cidadao c38 = new Cidadao(8);
        Cidadao c39 = new Cidadao(8);
        Cidadao c40 = new Cidadao(8);
        Cidadao c41 = new Cidadao(8);
        Cidadao c42 = new Cidadao(8);
        Cidadao c43 = new Cidadao(8);
        Cidadao c44 = new Cidadao(8);
        Cidadao c45 = new Cidadao(8);
        Cidadao c46 = new Cidadao(8);
        Cidadao c47 = new Cidadao(8);
        Cidadao c48 = new Cidadao(8);
        Cidadao c49 = new Cidadao(8);
        Cidadao c50 = new Cidadao(8);
        Cidadao c51 = new Cidadao(8);
        Cidadao c52 = new Cidadao(8);
        Cidadao c53 = new Cidadao(8);
        Cidadao c54 = new Cidadao(8);
        Cidadao c55 = new Cidadao(8);
        Cidadao c56 = new Cidadao(8);
        Cidadao c57 = new Cidadao(8);
        Cidadao c58 = new Cidadao(8);
        Cidadao c59 = new Cidadao(8);
        Cidadao c60 = new Cidadao(8);
        Cidadao c61 = new Cidadao(8);
        Cidadao c62 = new Cidadao(8);
        Cidadao c63 = new Cidadao(8);
        Cidadao c64 = new Cidadao(8);
        Cidadao c65 = new Cidadao(8);
        Cidadao c66 = new Cidadao(8);
        Cidadao c67 = new Cidadao(8);
        Cidadao c68 = new Cidadao(8);
        Cidadao c69 = new Cidadao(8);
        Cidadao c70 = new Cidadao(8);
        Cidadao c71 = new Cidadao(8);
        Cidadao c72 = new Cidadao(8);
        Cidadao c73 = new Cidadao(8);
        Cidadao c74 = new Cidadao(8);
        Cidadao c75 = new Cidadao(8);
        Cidadao c76 = new Cidadao(8);
        Cidadao c77 = new Cidadao(8);
        Cidadao c78 = new Cidadao(8);
        Cidadao c79 = new Cidadao(8);
        Cidadao c80 = new Cidadao(8);
        Cidadao c81 = new Cidadao(8);
        
        filaAtendimento.inserirCidadao(c1, 0);
        filaAtendimento.inserirCidadao(c2, 0);
        filaAtendimento.inserirCidadao(c3, 0);
        filaAtendimento.inserirCidadao(c4, 0);
        filaAtendimento.inserirCidadao(c5, 0);
        filaAtendimento.inserirCidadao(c6, 0);
        filaAtendimento.inserirCidadao(c7, 0);
        filaAtendimento.inserirCidadao(c8, 0);
        filaAtendimento.inserirCidadao(c9, 0);
        filaAtendimento.inserirCidadao(c10, 0);
        filaAtendimento.inserirCidadao(c11, 0);
        filaAtendimento.inserirCidadao(c12, 0);
        filaAtendimento.inserirCidadao(c13, 0);
        filaAtendimento.inserirCidadao(c14, 0);
        filaAtendimento.inserirCidadao(c15, 0);
        filaAtendimento.inserirCidadao(c16, 0);
        filaAtendimento.inserirCidadao(c17, 0);
        filaAtendimento.inserirCidadao(c18, 0);
        filaAtendimento.inserirCidadao(c19, 0);
        filaAtendimento.inserirCidadao(c20, 0);
        filaAtendimento.inserirCidadao(c21, 0);
        filaAtendimento.inserirCidadao(c22, 0);
        filaAtendimento.inserirCidadao(c23, 0);
        filaAtendimento.inserirCidadao(c24, 0);
        filaAtendimento.inserirCidadao(c25, 0);
        filaAtendimento.inserirCidadao(c26, 0);
        filaAtendimento.inserirCidadao(c27, 0);
        
        
        filaAtendimento.inserirCidadao(c28, 1);
        filaAtendimento.inserirCidadao(c29, 1);
        filaAtendimento.inserirCidadao(c30, 1);
        filaAtendimento.inserirCidadao(c31, 1);
        filaAtendimento.inserirCidadao(c32, 1);
        filaAtendimento.inserirCidadao(c33, 1);
        filaAtendimento.inserirCidadao(c34, 1);
        filaAtendimento.inserirCidadao(c35, 1);
        filaAtendimento.inserirCidadao(c36, 1);
        filaAtendimento.inserirCidadao(c37, 1);
        filaAtendimento.inserirCidadao(c38, 1);
        filaAtendimento.inserirCidadao(c39, 1);
        filaAtendimento.inserirCidadao(c40, 1);
        filaAtendimento.inserirCidadao(c41, 1);
        filaAtendimento.inserirCidadao(c42, 1);
        filaAtendimento.inserirCidadao(c43, 1);
        filaAtendimento.inserirCidadao(c44, 1);
        filaAtendimento.inserirCidadao(c45, 1);
        filaAtendimento.inserirCidadao(c46, 1);
        filaAtendimento.inserirCidadao(c47, 1);
        filaAtendimento.inserirCidadao(c48, 1);
        filaAtendimento.inserirCidadao(c49, 1);
        filaAtendimento.inserirCidadao(c50, 1);
        filaAtendimento.inserirCidadao(c51, 1);
        filaAtendimento.inserirCidadao(c52, 1);
        filaAtendimento.inserirCidadao(c53, 1);
        filaAtendimento.inserirCidadao(c54, 1);
        
        filaAtendimento.inserirCidadao(c55, 2);
        filaAtendimento.inserirCidadao(c56, 2);
        filaAtendimento.inserirCidadao(c57, 2);
        filaAtendimento.inserirCidadao(c58, 2);
        filaAtendimento.inserirCidadao(c59, 2);
        filaAtendimento.inserirCidadao(c60, 2);
        filaAtendimento.inserirCidadao(c61, 2);
        filaAtendimento.inserirCidadao(c62, 2);
        filaAtendimento.inserirCidadao(c63, 2);
        filaAtendimento.inserirCidadao(c64, 2);
        filaAtendimento.inserirCidadao(c65, 2);
        filaAtendimento.inserirCidadao(c66, 2);
        filaAtendimento.inserirCidadao(c67, 2);
        filaAtendimento.inserirCidadao(c68, 2);
        filaAtendimento.inserirCidadao(c69, 2);
        filaAtendimento.inserirCidadao(c70, 2);
        filaAtendimento.inserirCidadao(c71, 2);
        filaAtendimento.inserirCidadao(c72, 2);
        filaAtendimento.inserirCidadao(c73, 2);
        filaAtendimento.inserirCidadao(c74, 2);
        filaAtendimento.inserirCidadao(c75, 2);
        filaAtendimento.inserirCidadao(c76, 2);
        filaAtendimento.inserirCidadao(c77, 2);
        filaAtendimento.inserirCidadao(c78, 2);
        filaAtendimento.inserirCidadao(c79, 2);
        filaAtendimento.inserirCidadao(c80, 2);
        filaAtendimento.inserirCidadao(c81, 2);
        
        System.out.println(filaAtendimento.exibirFila());
        
        System.out.println("-----------------------------------------------------------------");
        filaAtendimento.atenderCidadao();
        System.out.println(filaAtendimento.exibirFila());
    }
    */
}

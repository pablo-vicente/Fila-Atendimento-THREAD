/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pablo
 */
public class FilaAtendimento {
    
    private Prioridade prioridade;
    
    public FilaAtendimento(){
        prioridade = new Prioridade(0);
        Prioridade prioridade2 = new Prioridade(1);
        Prioridade prioridade3 = new Prioridade(2);
        prioridade.setPrioridade(prioridade2);
        prioridade2.setPrioridade(prioridade3);
    }
    //Exibe a fila de atendimento
    public String exibirFila(){
        String separador = "_______________________________________________________________\n";//Separado para exibir a fila
        String fila = separador; //Fila inicia com serpador
        int contador = 0;//Conta quantos cidadao estão na fila+
        synchronized(prioridade){
            Prioridade tempPrioridade = prioridade; //Incia com a primeira prioridade conforme percorre a lista muda
            while(tempPrioridade!=null){//Verificia se a fila aponta para outra prioridade,vai retornar null na ultima prioridade, ou seja fim da fila
                fila = fila + "[======================== PRIORIDADE "+tempPrioridade.getCod()+" ========================]\n";//Indentificador de prioridade
                Cidadao tempCidadao = tempPrioridade.getCidadao();//Percorre a lista e cidadaos
                while(tempCidadao!=null){//Verifica se a prioridade ou cidadao aponta para alguma cidadao, retornar null se for ultimo cidadao ou se a prioridade estiver vazia
                    contador++;//increnta cada vez que encontrar um cidadao na fila

                    /*
                        Formata a fila exibir na console
                            01P1º | ID : XXX-000 | Tempo Atendimento: 0 | Promovido: False
                    */
                    fila = fila + tempPrioridade.getCod()+"P";//Exibe a ordem de atendimento
                    //Se a ordem de atendimento for maior que 10 adiciona um espaço a mais antes da ordem para ficar padronizado 
                    if(contador<10){
                        fila = fila + "  "+contador;
                    }else{
                        fila = fila + " " +contador;
                    }
                    fila = fila +"ª | "+"ID: "+tempCidadao.getIdCidadao()+" | "+"Tempo Atendimento: "+tempCidadao.getTempoAtendimento()+" | "+"Promovido: " +tempCidadao.isPromovido()+"\n";//Fim formatação
                    tempCidadao = tempCidadao.getCidadao();//Pega proximo cidadao
                }
                contador = 0; //Reseta quando a fila aponta para cidadao nulll, onde passa a contar a proxima fila de prioridade
                tempPrioridade = tempPrioridade.getPrioridade();//Muda de prioridade quandao cidadao aponta para NULL
            }//Caso a fila esteja vazia vai exibir somente dois separadores
            fila = fila + separador;//Adiciona separador no fim da fila
            
            prioridade.notifyAll();
            return fila;
        }
    }
    
    
    public void inserirCidadao(Cidadao cidadao, int codPrioridadeCidado){
        synchronized(prioridade){
            Prioridade temp = prioridade;
            while(temp.getCod()!=codPrioridadeCidado){
                temp = temp.getPrioridade();
            }
            Cidadao primeiroCidadao = temp.getCidadao();
            if(primeiroCidadao==null){
                temp.setCidadao(cidadao);
            }else{
                while(primeiroCidadao.getCidadao()!=null){
                    primeiroCidadao = primeiroCidadao.getCidadao();
                }
                primeiroCidadao.setCidadao(cidadao);
            }
            prioridade.notifyAll();
        }
        
    }
    
    public Cidadao atenderCidadao(){
        synchronized(prioridade){
            
            Prioridade tempPrioridade = prioridade;
            //procua a lista com cidadaos para serem atendidos
            while(tempPrioridade.getCidadao()== null){
                tempPrioridade.setQntAtendidoSequen(0);
                if(tempPrioridade.getCod()==2){
                    return null;
                }else{
                    tempPrioridade = tempPrioridade.getPrioridade();
                }
            }
            Cidadao cidadaoParaAtender = tempPrioridade.getCidadao();
            tempPrioridade.setCidadao(cidadaoParaAtender.getCidadao());
            tempPrioridade.setQntAtendidoSequen(tempPrioridade.getQntAtendidoSequen()+1);

            //Se for prioridade 2 nunca vai ser promovido
            if(cidadaoParaAtender.isPromovido()){
                tempPrioridade.getPrioridade().setQntAtendidoSequen(tempPrioridade.getPrioridade().getQntAtendidoSequen()+1);
            }else {
                //se a lista for com prioridade 3 nao pode ser 0 na prioridade 3 pois não exite
                if(tempPrioridade.getCod()!=2){
                    tempPrioridade.getPrioridade().setQntAtendidoSequen(0);
                }
            }
            int qntEmSequencia = tempPrioridade.getQntAtendidoSequen();
            while(qntEmSequencia==3){
                if(tempPrioridade.getCod()!=2){
                    Cidadao tempCidadao = tempPrioridade.getCidadao();
                    Cidadao cidadaoPromvido = tempPrioridade.getPrioridade().getCidadao();
                    if(cidadaoPromvido!=null){
                        cidadaoPromvido.setPromovido(true);
                        if(tempCidadao == null){
                            tempPrioridade.setCidadao(cidadaoPromvido);
                        }else {
                            while(tempCidadao.getCidadao()!=null){
                                tempCidadao = tempCidadao.getCidadao();
                            }
                            tempCidadao.setCidadao(cidadaoPromvido);
                        }
                        tempPrioridade.getPrioridade().setCidadao(cidadaoPromvido.getCidadao());
                        cidadaoPromvido.setCidadao(null);
                        tempPrioridade.setQntAtendidoSequen(0);
                    }
                }else{
                    break;
                }
                    qntEmSequencia = tempPrioridade.getPrioridade().getQntAtendidoSequen();
                    tempPrioridade = tempPrioridade.getPrioridade();
            }
        prioridade.notifyAll();
        return cidadaoParaAtender;
        }
    }
    
    public boolean isListaVazia(){
        Prioridade tempPrioridade = prioridade;
        Cidadao fila0 = tempPrioridade.getCidadao();
        Cidadao fila1 = tempPrioridade.getPrioridade().getCidadao();
        Cidadao fila2 = tempPrioridade.getPrioridade().getPrioridade().getCidadao();
        
        if(fila0 == null && fila1 == null && fila2 == null){
            return true;
        }else{
            return false;
        }
    }
}

import java.util.ArrayList;

public class Tabuleiro {
    private String reset = "\u001B[0m";
    private String[] tabuleiro = new String[41];
    private int i;
    MetodoImplements metodo = new MetodoImplements();
      
    public void construirTabuleiro(){
        for(i=1; i<41; i++){
            tabuleiro[i] = ".";
        } 
    }

    public void imprimirTabuleiro(){        
        for(i=1; i<41; i++){      
            if(tabuleiro[i].equals(".")){
                System.out.print(reset);
            }

            System.out.printf(tabuleiro[i] + " ");

            if( i%8 == 0)
                System.out.println();         
        }
    }

    public void posicionarJogadores(ArrayList<Jogador> jogadores,Jogador jogador){
        for(Jogador j : jogadores){
            if(j.equals(jogador))
                tabuleiro[j.getPosicao()] = ".";
            else
                tabuleiro[j.getPosicao()] = j.getCor();
                
        }
    }

    public void sobreporJogador(int posicao, String cor){
        tabuleiro[posicao] = cor;
    }

    /*public void movimentoCasaSorte(ArrayList<Jogador> jogadores,Jogador jogador,int posicaoAntiga){
        int passos;
        for(passos = 1; passos <= 3;passos++){
            System.out.println();
            construirTabuleiro();
        }
    }*/
    //para depois
    //adidcionar metodo movimento que mostra o movimento realizado pelo jogador 
    public void movimento(ArrayList<Jogador> jogadores,Jogador jogador,int soma,int posicaoAntiga){
        int passos;
        for(passos = 1; passos <= soma; passos++){
            System.out.println();
            construirTabuleiro();
            
            try {
                posicionarJogadores(jogadores,jogador);//imprime o jogador na posição futura
                sobreporJogador(passos + posicaoAntiga, jogador.getCor());//realiza o movimento
            } catch (Exception e) {
                break;
            }
            
            imprimirTabuleiro();
            metodo.delay();    
        }
    } 
}
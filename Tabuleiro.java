import java.util.ArrayList;

public class Tabuleiro {
    String reset = "\u001B[0m";
    String[] tabuleiro = new String[41];
    int i;
    private Casa[] casas;
    public Tabuleiro() {

        casas = new Casa[41];
        /*for(int i = 1; i <= 40; i++) {
            switch(i) {
                case 5:
                case 15:
                case 30:
                    casas[i] = new CasaSorte(i);
                    break;

                case 10:
                case 25:
                case 38:
                    casas[i] = new CasaPerdeRodada(i);
                    break;

                case 13:
                    casas[i] = new CasaSurpresa(i);
                    break;

                case 17:
                case 27:
                    casas[i] = new CasaVoltaInicio(i);
                    break;

                case 20:
                case 35:
                    //casas[i] = new CasaMagica(i);
                    break;

                default:
                    casas[i] = new CasaNormal(i);
            }
        }*/
    }

    //devo criar dois tabuleiros. um para representação visual no terminal.
    // a outra para interação do jogador com o tabuleiro.

    public Casa getCasa(int numero) {
        return casas[numero];
    }
    

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

            if( (i)%8 == 0)
                System.out.println();
        }
    }

    public void posicionarJogadores(ArrayList<Jogador> jogadores){
        for(Jogador jogador : jogadores){
            tabuleiro[jogador.getPosicao()] = jogador.getCor();
        }
    }

    public void sobreporJogador(int posicao, String cor){
        tabuleiro[posicao] = cor;
    }
    

    //para depois
    //adidcionar metodo movimento que mostra o movimento realizado pelo jogador 
    /*public void movimento(int soma){
        int passos;
        for(passos = 0; passos < soma; passos++){
            sleep -> 
            construirTabuleiro();
            posicionarJogadores(jogadores);
            sobreporJogador(passos+jogador.getPosicao();jogador.cor());
            imprimirTabuleiro();    
        }
    }
     */
    
}
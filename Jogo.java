import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private final int modo; 
    private final ArrayList<Jogador> jogadores = new ArrayList<>();
    private final Scanner teclado = new Scanner(System.in);
    private final ArrayList<String> nomeJogadores = new ArrayList<>();
    private final String reset = "\u001B[0m";
    
    private final Tabuleiro tabuleiro = new Tabuleiro();
    private int qtd;
    private int rodadas = 0;
    Jogador jogadorVencedor = null;
    
    public Jogo(int modo){
        this.modo = modo;
    }
    
    public void cadastrarJogadores(){
        String corJogador;
        String nomeJogador; 
        
        int tipoJogador;
        int jogadorNormal = 0;
        int jogadorSortudo = 0;
        int jogadorAzarado = 0;
        
        Cor cor = new Cor();

        do{
            System.out.println("Digite a quantidade de jogadores (2-6):");
            qtd = teclado.nextInt();
            teclado.nextLine();

        }while(qtd < 2 || qtd > 6);


        for(int indice = 0; indice < qtd; indice++){
            while(true){
                System.out.printf("\nEscolha a cor do jogador %d:\n", indice+1);
                cor.mostrarCores();
                
                corJogador = teclado.nextLine();

                if(cor.selecionarCor(corJogador))
                    break;
                else
                    System.out.println("Cor indisponível!");
            }

            while(true){
                System.out.println("Nome do jogador: ");
                nomeJogador = teclado.nextLine();
                
                if(nomeJogadores.contains(nomeJogador))
                    System.out.println("Já existe um jogador com esse nome!");
                
                else{
                    nomeJogadores.add(nomeJogador);
                    break;
                }    
            }
            
            while(true){
                System.out.println("Tipo: 1 - Normal | 2 - Sortudo | 3 - Azarado");
                tipoJogador = teclado.nextInt();
                teclado.nextLine();
                
                if(tipoJogador >= 1 && tipoJogador <= 3 )
                    break;
            }    

            switch(tipoJogador){

                case 1:
                    jogadores.add(new JogadorNormal(corJogador,nomeJogador));
                    jogadorNormal++;
                    break;

                    case 2:
                        jogadores.add(new JogadorSorte(corJogador,nomeJogador));
                        jogadorSortudo++;
                        break;
                        
                    case 3:
                        jogadores.add(new JogadorAzarado(corJogador,nomeJogador));
                        jogadorAzarado++;
                        break;
                    }
                }

                if( (jogadorNormal == 0 && jogadorAzarado == 0) || (jogadorNormal == 0 && jogadorSortudo == 0) || (jogadorSortudo == 0 && jogadorAzarado == 0) ){                        
                    System.out.println("Deve existir pelo menos dois tipos diferentes!");
                    jogadores.clear();
                    nomeJogadores.clear();
                    cadastrarJogadores();
                }
    }
    
    public void partida(){
        tabuleiro.construirTabuleiro();
        int posicaoAntiga;
        
        do{         
            rodadas++;
            for(Jogador jogadorSelecionado : jogadores){
                
                if(jogadorSelecionado.isPerderRodada()){
                    jogadorSelecionado.setPerderRodada(false);
                    continue;
                }

                tabuleiro.construirTabuleiro();
                tabuleiro.posicionarJogadores(jogadores, jogadorSelecionado);
                tabuleiro.sobreporJogador(jogadorSelecionado.getPosicao(),jogadorSelecionado.getCor());
                
                System.out.printf("\nVez de %s\n",jogadorSelecionado.getNome());
                tabuleiro.imprimirTabuleiro();
                
                if(modo == 1){  
                    System.out.println("\nAperte ENTER para jogar dados");
                    teclado.nextLine();

                    posicaoAntiga = jogadorSelecionado.getPosicao();

                    System.out.printf("Soma dos dados: %d - Posição de %s: %d\n",
                    jogadorSelecionado.jogarDados(),
                    jogadorSelecionado.getNome(),
                    jogadorSelecionado.getPosicao());
                    
                    tabuleiro.movimento(jogadores, jogadorSelecionado,jogadorSelecionado.getSoma(),posicaoAntiga);
                    instanciarCasa(jogadorSelecionado,jogadorSelecionado.getPosicao());
                    
                    System.out.println();
                    
                    while(jogadorSelecionado.getDado1() == jogadorSelecionado.getDado2()) {
                        
                        posicaoAntiga = jogadorSelecionado.getPosicao();
                        System.out.println("\nDados iguais! Jogue novamente!");
                        System.out.println("\nAperte ENTER para jogar dados");
                        teclado.nextLine();
                        
                        System.out.printf("Soma dos dados: %d - Posição de %s: %d\n",
                        jogadorSelecionado.jogarDados(),
                        jogadorSelecionado.getNome(),
                        jogadorSelecionado.getPosicao());
                        
                        tabuleiro.movimento(jogadores, jogadorSelecionado,jogadorSelecionado.getSoma(),posicaoAntiga);
                        instanciarCasa(jogadorSelecionado,jogadorSelecionado.getPosicao());                    
                        
                        System.out.println();                   
                    }                         
                }

                if(modo == 2){
                    int novaPosicao;
                    while (true) { 
                       
                        System.out.printf("Selecione a nova posição de %s:\n",jogadorSelecionado.getNome());
                        novaPosicao = teclado.nextInt();
                        teclado.nextLine();

                        if(novaPosicao < jogadorSelecionado.getPosicao() || novaPosicao < 1 || novaPosicao > 40)
                            System.out.println("Posição inválida!");
                        else{
                            jogadorSelecionado.setPosicao(novaPosicao);
                            instanciarCasa(jogadorSelecionado, jogadorSelecionado.getPosicao());
                            break;
                        }
                    }    
                }
                System.out.println();                       
                System.out.printf("%s----------------------------------\n",reset);
                    
                if(jogadorSelecionado.Venceu()){
                    jogadorVencedor = jogadorSelecionado;
                    break;
                }
            }     
    }while(jogadorVencedor == null);

    }
    
    private Jogador instanciarCasa(Jogador jogador,int posicao){
        String nomeJogador;
    
        //fica uma rodada sem jogar
        if(posicao == 10 || posicao == 25 || posicao == 38){
            Casa casa = new CasaPerdeRodada();
            casa.aplicarEfeito(jogador);
        }
        
        //troca o tipo de jogador
        if(posicao == 13){
            Casa casa = new CasaSurpresa();
            jogador = casa.aplicarEfeito(jogador);
        }
        
        //anda 3 casas se não for um azarado
        if(posicao == 5 || posicao == 15 || posicao == 30){
            if(jogador.getEstrategiaDados() != EstrategiaDados.azarado())
                tabuleiro.movimento(jogadores, jogador,3 ,posicao);
            Casa casa = new CasaSorte();
            casa.aplicarEfeito(jogador);
        }
        
        //escolhe um jogador para voltar ao inicio do jogo
        if(posicao == 17 || posicao == 27){
            Casa casa = new CasaVoltaInicio();
            do{
                mostrarJogadores();
                System.out.println("\nEscolha um jogador para voltar ao inicio");
                nomeJogador = teclado.nextLine();
                
            }while(escolherJogador(nomeJogador) == null);
            
            casa.aplicarEfeito(escolherJogador(nomeJogador));   

            tabuleiro.construirTabuleiro();
            tabuleiro.posicionarJogadores(jogadores, jogador);
            tabuleiro.sobreporJogador(jogador.getPosicao(),jogador.getCor());
            tabuleiro.imprimirTabuleiro();
        }
        
        //troca de posição com o ultimo
        if(posicao == 20 || posicao == 35){
            CasaMagica casa = new CasaMagica();
            casa.encontrarUltimo(jogadores,jogador);
            
            tabuleiro.construirTabuleiro();
            tabuleiro.posicionarJogadores(jogadores, jogador);
            tabuleiro.sobreporJogador(jogador.getPosicao(),jogador.getCor());
            tabuleiro.imprimirTabuleiro();
            
            casa.aplicarEfeito(jogador);
        }  
        return jogador;
    }
    
    public Jogador escolherJogador(String nome){
        for(Jogador jogador : jogadores){
            if(jogador.getNome().equals(nome))
                return jogador;
        }
        return null;
    }
    
    public void mostrarJogadores(){
        for(Jogador jogador : jogadores){
            System.out.printf("Nome: %s - Peão: %s %s\n",jogador.getNome(),jogador.getCor(),reset);
        }
    }

    public void mostrarEstatisticas(){
        int indice;
        System.out.println("ESTATISTICAS DA PARTIDA");
       
        for(indice = 0; indice < jogadores.size();indice++){
            if(modo == 1)
                System.out.printf("%d. Nome: %s - Quantidade de dados lançados: %d - Posição: %d\n",
                (indice+1),
                jogadores.get(indice).getNome(),
                jogadores.get(indice).getDadosLancados(),
                jogadores.get(indice).getPosicao());
                
            else
                System.out.printf("%d. Nome: %s - Posição: %d\n",
                (indice+1),
                jogadores.get(indice).getNome(),
                jogadores.get(indice).getPosicao());
        }
        
        if(jogadorVencedor != null)
            System.out.println("\nJogador vencedor: " + jogadorVencedor.getNome());
        
        System.out.println("Quantidade de rodadas no total: " + rodadas);       
    } 
}
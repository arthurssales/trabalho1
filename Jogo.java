import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private Scanner teclado = new Scanner(System.in);
    //private boolean jgval = false;
    //private Random random = new Random();
    private ArrayList<String> nomeJogadores = new ArrayList<>();
    String reset = "\u001B[0m";
   
    Cor cor = new Cor();
    Tabuleiro tabuleiro = new Tabuleiro();
    private boolean casaNormal;
    
    int qtd;
    public void cadastrarJogadores(){
        String corJogador;
        String nomeJogador; 
        int tipoJogador;

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

            //criar verificação que obrigue a ter dois tipos diferentes caso tenha apenas dois jogadores e tres tipos diferentes se tiver apenas tres jogadores
            switch(tipoJogador){

                case 1:
                    jogadores.add(new JogadorNormal(corJogador,nomeJogador));
                    break;

                case 2:
                    jogadores.add(new JogadorSorte(corJogador,nomeJogador));
                    break;

                case 3:
                    jogadores.add(new JogadorAzarado(corJogador,nomeJogador));
                    break;
            }
        }
    }
   
   /*public void iniciarJogo(){
        System.out.println("JOGO INICIADO!");
        int rnd;
        boolean jogoacabou = false;
        
        while(!jogoacabou){
            

        }
        }*/

    private int rodadas = 0;
    //dentro da partida ocorrerá a interação das casas com o jogador
    Jogador jogadorVencedor = null;
    public void partida(){
        tabuleiro.construirTabuleiro();
        
        do{         
            rodadas++;
            for(Jogador jogadorSelecionado : jogadores){
                
                if(jogadorSelecionado.isPerderRodada()){
                    jogadorSelecionado.setPerderRodada(false);
                    continue;
                }

                tabuleiro.construirTabuleiro();
                
                tabuleiro.posicionarJogadores(jogadores);
                tabuleiro.sobreporJogador(jogadorSelecionado.getPosicao(),jogadorSelecionado.getCor());
                
                System.out.println("----------------------------------");
                System.out.printf("\n\nVez de %s\n",jogadorSelecionado.getNome());
                tabuleiro.imprimirTabuleiro();
                
                System.out.println("\nAperte ENTER para jogar dados");
                teclado.nextLine();

                System.out.printf("Soma dos dados: %d - Posição de %s: %d\n",
                    jogadorSelecionado.jogarDados(),
                    jogadorSelecionado.getNome(),
                    jogadorSelecionado.getPosicao());
                
                    //jogadorSelecionado.mostrarResultado();
                    
                    instanciarCasa(jogadorSelecionado,jogadorSelecionado.getPosicao());
                    if(!casaNormal)
                        tabuleiro.imprimirTabuleiro();
                
                System.out.println();

                //para encerrar o lancamento de dados e evitar uma exceção no final do programa, posso usar um try catch
                while(jogadorSelecionado.getDado1() == jogadorSelecionado.getDado2()) {
                    tabuleiro.construirTabuleiro();
                    
                    try{   
                        tabuleiro.posicionarJogadores(jogadores);
                        tabuleiro.sobreporJogador(jogadorSelecionado.getPosicao(),jogadorSelecionado.getCor());
                    } 
                    catch (Exception e) {
                        break;
                    }
                    
                    tabuleiro.imprimirTabuleiro();
                    
                    System.out.println("\nDados iguais! Jogue novamente!");
                    System.out.println("\nAperte ENTER para jogar dados");
                    teclado.nextLine();
                    
                    System.out.printf("Soma dos dados: %d - Posição de %s: %d\n",
                    jogadorSelecionado.jogarDados(),
                    jogadorSelecionado.getNome(),
                    jogadorSelecionado.getPosicao());
                        
                    //jogadorSelecionado.mostrarResultado();
                    instanciarCasa(jogadorSelecionado,jogadorSelecionado.getPosicao());
                }

                System.out.println();               
                tabuleiro.construirTabuleiro();

                try{
                    tabuleiro.posicionarJogadores(jogadores);
                    tabuleiro.sobreporJogador(jogadorSelecionado.getPosicao(),jogadorSelecionado.getCor());
                    tabuleiro.imprimirTabuleiro();
                    
                } 
                catch (Exception e) {
                }
                
                if(jogadorSelecionado.Venceu()){
                    jogadorVencedor = jogadorSelecionado;
                    break;
                }
            }     
        }while(jogadorVencedor == null);    
    }
    

    private void instanciarCasa(Jogador jogador,int posicao){
        String nomeJogador;
        casaNormal = false;

        //fica uma rodada sem jogar
        //ok
        if(posicao == 10 || posicao == 25 || posicao == 38){
            casaNormal = true;
            Casa casa = new CasaPerdeRodada();
            casa.aplicarEfeito(jogador);
        }
        
        //troca o tipo de jogador
        if(posicao == 13){
            casaNormal = true;
            Casa casa = new CasaSurpresa();
            casa.aplicarEfeito(jogador);
        }
        
        //anda 3 casas se não for um azarado
        //ok
        if(posicao == 5 || posicao == 15 || posicao == 30){
            casaNormal = true;
            Casa casa = new CasaSorte();
            casa.aplicarEfeito(jogador);
        }
        
        //escolhe um jogador para voltar ao inicio do jogo
        //ok
        if(posicao == 17 || posicao == 27){
            casaNormal = true;
            Casa casa = new CasaVoltaInicio();
            do{
                mostrarJogadores();
                System.out.println("\nEscolha um jogador para voltar ao inicio");
                nomeJogador = teclado.nextLine();
                
            }while(escolherJogador(nomeJogador) == null);
            
            casa.aplicarEfeito(escolherJogador(nomeJogador));   
        }
        
        //troca de posição com o ultimo
        if(posicao == 20 || posicao == 35){
            CasaMagica casa = new CasaMagica();
            casa.encontrarUltimo(jogadores,jogador);
            casa.aplicarEfeito(jogador);
        }  
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
            System.out.printf("Nome: %s - Cor: %s %s\n",jogador.getNome(),jogador.getCor(),reset);
        }
    }

    public void mostrarEstatisticas(){
        int indice;
        System.out.println("ESTATISTICAS DA PARTIDA");
        
        for(indice = 0; indice < jogadores.size();indice++){
            System.out.printf("%d. Nome: %s - Quantidade de dados lançados: %d - Posição: %d\n",
            (indice+1),
            jogadores.get(indice).getNome(),
            jogadores.get(indice).getDadosLancados(),
            jogadores.get(indice).getPosicao());
        }
        
        if(jogadorVencedor != null)
            System.out.println("\nJogador vencedor: " + jogadorVencedor.getNome());
        
        System.out.println("Quantidade de rodadas no total: " + rodadas);       
    }
    
}
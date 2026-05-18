import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int modoJogo = 0;
        MetodoImplements metodo = new MetodoImplements();
        
        
        System.out.println("Escolha o modo de jogo: ");
        do{ 
            System.out.println("1 - Lançar dados\n2 - Modo debug");           
            modoJogo = teclado.nextInt();
        } while (modoJogo < 1 || modoJogo > 2);
        
        Jogo jogo = new Jogo(modoJogo);
        
        jogo.cadastrarJogadores();
        metodo.limparTela();
        
        System.out.println("\nJogadores cadastrados com sucesso!");
        System.out.println("Lista dos jogadores cadastrados: ");
        jogo.mostrarJogadores();

        System.out.println("--------------------------------------");
        System.out.println("\n\nINICIANDO JOGO");
        jogo.partida();

        jogo.mostrarEstatisticas();
        
        /*1. cadastro de jogadores:
        - não permitir tipos de jogador repetidos caso tenha somente 2 ou 3 jogadores na partida (importante)

        
        2. inicio da partida
        2.1. interação dos jogadores com o tabuleiro (importante):
        - como alterar o tipo de jogador enquanto o programa esta sendo executado?
    
        3. mostrar estatisticas:
        - quantidade de vezes em que um jogador lançou dados repetidos
        - casas especiais em que o jogador caiu
        */
    }
}
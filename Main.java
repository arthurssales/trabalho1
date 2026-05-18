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
        /* 
        - como alterar o tipo de jogador enquanto o programa esta sendo executado?
        */
    }
}
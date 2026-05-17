public class Main {
    public static void main(String[] args){
        Jogo jogo = new Jogo();
        //MetodoImplements metodo = new MetodoImplements();
        //devo aumentar a main? 
        jogo.cadastrarJogadores();
        //metodo.limparTela();
        System.out.println("\nJogadores cadastrados com sucesso!");
        System.out.println("Lista dos jogadores cadastrados: ");
        jogo.mostrarJogadores();

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
import java.util.Random;
public class CasaSurpresa extends Casa{
    Random random = new Random();
    private int tipo;
    private Cor cor = new Cor();

    @Override
    public Jogador aplicarEfeito(Jogador jogador){
        Jogador novoJogador = null;
        String corOriginal = cor.retornarNomeCor(jogador.getCor());

        tipo = random.nextInt(3);
        
        //normal
        System.out.println("Escolhendo um tipo ");
        
        switch (tipo) {
            case 0:
                System.out.printf("%s virou normal",jogador.getNome());
                novoJogador = new JogadorNormal(corOriginal,jogador.getNome());
                //jogador.setSubstituido(true);
                break;
            
            case 1:
                System.out.printf("%s virou sortudo",jogador.getNome());
                novoJogador = new JogadorSorte(corOriginal, jogador.getNome());
                //jogador.setSubstituido(true);
                break;
            
            case 2:
                System.out.printf("%s virou azarado",jogador.getNome());
                novoJogador = new JogadorAzarado(corOriginal, jogador.getNome());
                //jogador.setSubstituido(true);
                break;
            
            default:
                break;
        }

        if(novoJogador != null){
            novoJogador.setPosicao(jogador.getPosicao());
            novoJogador.setPerderRodada(jogador.isPerderRodada());
        }

        return novoJogador;
    }
}
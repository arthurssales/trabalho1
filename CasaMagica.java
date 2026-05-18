import java.util.ArrayList;
public class CasaMagica extends Casa {

    Jogador ultimoJogador = null;
       
    @Override
    public void aplicarEfeito(Jogador jogador){
            
        if(ultimoJogador != jogador) {
        
            int posAux = jogador.getPosicao();                
            jogador.setPosicao(ultimoJogador.getPosicao());
            ultimoJogador.setPosicao(posAux);

            System.out.println("\n" + jogador.getNome() + " trocou de posição com " + ultimoJogador.getNome());
        }
        else {
            System.out.println("\n" + jogador.getNome() + " já está em último.");
        }
    }

    public Jogador encontrarUltimo(ArrayList<Jogador> jogadores, Jogador jogadorSelecionado){
       ultimoJogador = jogadores.get(0);

        for(Jogador j : jogadores){
            if(j.getPosicao() < ultimoJogador.getPosicao()){
                ultimoJogador = j;
            }
        }
    
        return ultimoJogador;
    }
}
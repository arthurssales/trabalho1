import java.util.ArrayList;
public class CasaMagica extends Casa {

    Jogador ultimo = null;
       
    @Override
    public void aplicarEfeito(Jogador jogador){//,Jogo jogo) {
            
        if(ultimo != jogador) {
        
            int posAux = jogador.getPosicao();                
            jogador.setPosicao(ultimo.getPosicao());
            ultimo.setPosicao(posAux);

            System.out.println("\n " + jogador.getNome() + " trocou de posição com " + ultimo.getNome());
        }
        else {
            System.out.println("\n" + jogador.getNome() + " já está em último.");
        }
    }

    public Jogador encontrarUltimo(ArrayList<Jogador> jogadores, Jogador jogadorSelecionado){
        ultimo = jogadores.get(0);
        //definir qual é a menor posicao
        for(Jogador jogador : jogadores){
            if(jogador.getPosicao() < ultimo.getPosicao()){
                ultimo = jogador;
            }
        }
    
        return ultimo;
    }
}
public class CasaSorte extends Casa {

   
    @Override
    public Jogador aplicarEfeito(Jogador jogador){//, Jogo jogo) {
        if(jogador != null){

                if(!(jogador instanceof JogadorAzarado)) {
                    
                    jogador.setPosicao(3 + jogador.getPosicao());
                    System.out.println("\n" + jogador.getNome() + " avançou 3 casas!");
                }
                else {
                    System.out.println("\n" + jogador.getNome() +" é azarado e não ganhou bônus.");
                }
            
        }    
        return jogador;
    }
}
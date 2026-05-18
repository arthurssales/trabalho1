public class CasaVoltaInicio extends Casa {

   
    @Override
    public Jogador aplicarEfeito(Jogador jogador){//, Jogo jogo) {
            
            jogador.setPosicao(1);
            System.out.println("\n" + jogador.getNome() + " voltou ao início!");
        
        return jogador;
    }
    
}
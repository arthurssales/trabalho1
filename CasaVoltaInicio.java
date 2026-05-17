public class CasaVoltaInicio extends Casa {

   
    @Override
    public void aplicarEfeito(Jogador jogador){//, Jogo jogo) {
            
            jogador.setPosicao(1);
            System.out.println("\n" + jogador.getNome() + " voltou ao início!");
        
    }
}
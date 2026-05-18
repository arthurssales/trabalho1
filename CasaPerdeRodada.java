public class CasaPerdeRodada extends Casa {

    
    //acontece isso em apenas uma rodada, depois ele volta
    @Override
    public Jogador aplicarEfeito(Jogador jogador){//, Jogo jogo) {

        jogador.setPerderRodada(true);        
        System.out.println("\n" + jogador.getNome() + " perderá a próxima rodada!");
        return jogador;
    }
}
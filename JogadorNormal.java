public class JogadorNormal extends Jogador{
     
    public JogadorNormal(String cor,String nome){
        super(cor,nome);
        this.estrategiaDados = EstrategiaDados.normal();
    }

    @Override
    public int jogarDados() {
        int[] dados = estrategiaDados.lançar();
        dado1 = dados[0];
        dado2 = dados[1];
        soma = dado1 + dado2;
        
        posicao += soma;
        
        dadosLancados++;
        return soma;
    }

    
}
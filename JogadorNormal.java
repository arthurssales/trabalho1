import java.util.Random;

public class JogadorNormal extends Jogador{
    Random random = new Random();
    
    public JogadorNormal(String cor,String nome){
        super(cor,nome);
    }

    @Override
    public int jogarDados() {
        dado1 = random.nextInt(6)+1;
        dado2 = random.nextInt(6)+1;
        
        soma = dado1 + dado2;
        
        posicao += soma;
        
        dadosLancados++;
        return soma;
    }

    
}
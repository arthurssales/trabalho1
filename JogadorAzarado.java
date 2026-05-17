import java.util.Random;

public class JogadorAzarado extends Jogador {
    Random random = new Random();
    
    public JogadorAzarado(String cor,String nome) {
        super(cor,nome);
    }
    
    @Override
    public int jogarDados() {
        do {
            dado1 = random.nextInt(6) + 1;
            dado2 = random.nextInt(6) + 1;
            soma = dado1 + dado2;
        } while(soma > 6);
        
        
        posicao += soma;

        dadosLancados++;
        return soma;
    }
}
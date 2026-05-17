import java.util.Random;
public class JogadorSorte extends Jogador{
    
    public JogadorSorte(String cor,String nome) {
        super(cor,nome);
    }
    
    Random random = new Random();
    
    @Override
    public int jogarDados() {
        do {
            dado1 = random.nextInt(6) + 1;
            dado2 = random.nextInt(6) + 1;
            soma = dado1 + dado2;
        }while(soma < 7);
        
        
        posicao += soma;

        dadosLancados++;
        return soma;
    }
}
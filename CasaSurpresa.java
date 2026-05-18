import java.util.Random;
public class CasaSurpresa extends Casa{
    Random random = new Random();
    private int tipo;
    
    @Override
    public Jogador aplicarEfeito(Jogador jogador){
        
        tipo = random.nextInt(3);
        
        //normal
        System.out.println("Escolhendo um tipo ");
        
        switch (tipo) {
            case 0:
                jogador.setEstrategia(EstrategiaDados.normal());    
                System.out.printf("%s virou Normal!\n", jogador.getNome());
                break;
            
            case 1:
                jogador.setEstrategia(EstrategiaDados.sorte());
                System.out.printf("%s virou Sortudo!\n", jogador.getNome());
                break;
                
            case 2:
                jogador.setEstrategia(EstrategiaDados.azarado());
                System.out.printf("%s virou Azarado!\n", jogador.getNome());
                break;
            
            default:
                break;
        }

    

        return jogador;
    }
}
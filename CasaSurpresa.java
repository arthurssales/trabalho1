import java.util.Random;
public class CasaSurpresa extends Casa{
    Random random = new Random();
    private int tiposPossiveis;

    
    //ele pode tirar o mesmo tipo? acredito que não
    @Override
    public void aplicarEfeito(Jogador jogador){//, Jogo jogo) {
        
            System.out.println("Escolhendo um tipo ");
            tiposPossiveis = random.nextInt(3);
            
            switch(tiposPossiveis){
                case 0:
                    //normal
                    
                    case 1:
                //sortudo
                
                case 2:
                    //azarado
                    
                    
                    
                }
            
                


    }
}
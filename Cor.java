import java.util.ArrayList;

public class Cor {
    private final ArrayList<String> coresDisponiveis = new ArrayList<>();

    public Cor(){
        coresDisponiveis.add("vermelho");
        coresDisponiveis.add("azul");
        coresDisponiveis.add("branco");
        coresDisponiveis.add("ciano");
        coresDisponiveis.add("preto");
        coresDisponiveis.add("rosa");
    }
    
    public void mostrarCores(){
        for(String cor : coresDisponiveis){
            System.out.printf("[%s] ",cor);
        }
    }

    public String retornarNomeCor(String cor){
        System.out.println("DEBUG" +  cor);
        if(cor.contains("\u001B[31mV"))
            return "vermelho";

        if(cor.contains("\u001B[34mA"))
            return "azul";
        
        if(cor.contains("\u001B[37mB"))
            return "branco";
        
        if(cor.contains("\u001B[36mC"))
            return "ciano";
        
        if(cor.contains("\u001B[30mP"))
            return "preto";
        
        if(cor.contains("\u001B[35mR"))
            return "rosa";

        else
            return "ABACATE";
    }
    
    public boolean selecionarCor(String cor){
        if(coresDisponiveis.contains(cor)){
            coresDisponiveis.remove(cor);
            return true;
        }
        return false;
    }
    
}

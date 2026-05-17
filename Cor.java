import java.util.ArrayList;

public class Cor {
    private final ArrayList<String> coresDisponiveis = new ArrayList<>();


    //verificar se é necessario retirar as cores verde e amarelo, já que as iniciais são iguais a vermelho e azul
    public Cor(){
        coresDisponiveis.add("vermelho");
        coresDisponiveis.add("azul");
        coresDisponiveis.add("verde");
        coresDisponiveis.add("branco");
        coresDisponiveis.add("amarelo");
        coresDisponiveis.add("ciano");
        coresDisponiveis.add("preto");
        coresDisponiveis.add("rosa");
    }

    public void mostrarCores(){
        for(String cor : coresDisponiveis){
            System.out.printf("[%s] ",cor);
        }
    }

    public boolean selecionarCor(String cor){
        if(coresDisponiveis.contains(cor)){
            coresDisponiveis.remove(cor);
            return true;
        }
        return false;
    }

}

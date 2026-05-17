public abstract class Jogador {
    protected String cor;
    protected int posicao;
    protected boolean perderRodada;
    protected int jogadas;
    protected int dado1, dado2;
    protected int soma;
    protected String nome;
    protected int dadosLancados = 0;

    public Jogador(String cor,String nome) {
        this.nome = nome;
        posicao = 1;

        if(cor.equals("vermelho"))
            this.cor = "\u001B[31mV";
             
        if(cor.equals("azul"))
            this.cor = "\u001B[34mA";

        if(cor.equals("verde"))
            this.cor = "\u001B[32mV";
        
        if(cor.equals("amarelo"))
            this.cor = "\u001B[33mA";
        
        if(cor.equals("rosa"))
            this.cor = "\u001B[35mR";
        
        if(cor.equals("branco"))
            this.cor = "\u001B[37mB";
        
        if(cor.equals("preto"))
            this.cor = "\u001B[30mP";
        
        if(cor.equals("ciano"))
            this.cor = "\u001B[36mC";
    }

    public void mover(int valor) {
        posicao += valor;
    }

    public abstract int jogarDados();

    
    public void mostrarResultado(){
        System.out.printf("\nDado 1: %d - Dado 2: %d - Posição de %s: %d", dado1, dado2, nome, posicao);
    }

    public boolean Venceu(){
        if(posicao >= 40){    
            return true;
        }
        return false;
    }

    public int getDadosLancados(){
        return dadosLancados;
    }

    public int getPosicao() {
        return posicao;
    }

    public void alterarPosicao(){
        if(posicao > 40)
            posicao = 40;
    }
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
    public String getCor() {
        return cor;
    }

    public boolean isPerderRodada() {
        return perderRodada;
    }

    public void setPerderRodada(boolean perderRodada) {
        this.perderRodada = perderRodada;
    }

    public int getJogadas() {
        return jogadas;
    }

    public int getDado1() {
        return dado1;
    }

    public int getDado2() {
        return dado2;
    }
 
    public int getSoma() {
        return soma;
    }

    public String getNome() {
        return nome;
    }
}
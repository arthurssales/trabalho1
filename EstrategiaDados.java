
import java.util.Random;

public interface EstrategiaDados {
    // Retorna array com [dado1, dado2]
    int[] lançar();

    // Estratégia Normal: dados livres
    static EstrategiaDados normal() {
        return () -> {
            Random r = new Random();
            int d1 = r.nextInt(6) + 1;
            int d2 = r.nextInt(6) + 1;
            return new int[]{d1, d2};
        };
    }

    // Estratégia Sorte: repete até soma >= 7
    static EstrategiaDados sorte() {
        return () -> {
            Random r = new Random();
            int d1, d2;
            do {
                d1 = r.nextInt(6) + 1;
                d2 = r.nextInt(6) + 1;
            } while ((d1 + d2) < 7);
            return new int[]{d1, d2};
        };
    }

    // Estratégia Azarado: repete até soma <= 6
    static EstrategiaDados azarado() {
        return () -> {
            Random r = new Random();
            int d1, d2;
            do {
                d1 = r.nextInt(6) + 1;
                d2 = r.nextInt(6) + 1;
            } while ((d1 + d2) > 6);
            return new int[]{d1, d2};
        };
    }
}

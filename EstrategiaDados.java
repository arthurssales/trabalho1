
import java.util.Random;

public interface EstrategiaDados {
    // Retorna array com [dado1, dado2]
    int[] lançar();

    static EstrategiaDados normal() {
        return () -> {
            Random random = new Random();
            int d1 = random.nextInt(6) + 1;
            int d2 = random.nextInt(6) + 1;
            return new int[]{d1, d2};
        };
    }

    static EstrategiaDados sorte() {
        return () -> {
            Random random = new Random();
            int d1, d2;
            do {
                d1 = random.nextInt(6) + 1;
                d2 = random.nextInt(6) + 1;
            } while ((d1 + d2) < 7);
            return new int[]{d1, d2};
        };
    }

    // Estratégia Azarado: repete até soma <= 6
    static EstrategiaDados azarado() {
        return () -> {
            Random random = new Random();
            int d1, d2;
            do {
                d1 = random.nextInt(6) + 1;
                d2 = random.nextInt(6) + 1;
            } while ((d1 + d2) > 6);
            return new int[]{d1, d2};
        };
    }
}

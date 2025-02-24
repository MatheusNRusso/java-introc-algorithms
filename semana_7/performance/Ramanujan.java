import java.util.HashSet;

public class Ramanujan {

    /**
     * Verifica se um número n é um número de Ramanujan.
     * - Um número de Ramanujan pode ser expresso como a soma de dois cubos de duas maneiras distintas:
     *   n = a³ + b³ = c³ + d³, onde (a, b) ≠ (c, d).
     */
    public static boolean isRamanujan(long n) {
        if (n < 1) return false; // Números menores que 1 não podem ser números de Ramanujan.

        // Calcula o limite superior para os cubos possíveis (raiz cúbica de n).
        long limit = (long) Math.cbrt(n);

        // Cria um conjunto para armazenar todos os cubos até o limite.
        HashSet<Long> cubes = new HashSet<>();

        // Preenche o conjunto com os cubos de 1 até limit.
        for (long i = 1; i <= limit; i++) {
            cubes.add(i * i * i);
        }

        int count = 0; // Contador para o número de decomposições distintas.

        // Itera sobre os cubos no conjunto.
        for (long a : cubes) {
            long b3 = n - a; // Calcula o valor de b³ tal que a³ + b³ = n.

            // Verifica se b³ é um cubo válido e está no conjunto.
            if (b3 > 0 && cubes.contains(b3)) {
                count++; // Encontrou uma decomposição válida.

                // Se encontrarmos duas decomposições distintas, retornamos true.
                if (count == 2) return true;
            }
        }

        // Se não encontrarmos duas decomposições distintas, retornamos false.
        return false;
    }

    /**
     * Método principal que lê um número da linha de comando e verifica se ele é um número de Ramanujan.
     * - Lê o número n da linha de comando.
     * - Chama a função isRamanujan para verificar se n é um número de Ramanujan.
     * - Imprime o resultado.
     */
    public static void main(String[] args) {
        try {
            // Lê o número n da linha de comando.
            long n = Long.parseLong(args[0]);

            // Verifica se n é um número de Ramanujan e imprime o resultado.
            System.out.println(isRamanujan(n));
        } catch (NumberFormatException e) {
            // Trata erros de entrada inválida.
            System.out.println("Entrada inválida. Forneça um número inteiro positivo.");
        }
    }
}

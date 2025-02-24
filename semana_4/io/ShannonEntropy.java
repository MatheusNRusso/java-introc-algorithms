
public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]); // Número máximo de valores possíveis
        int[] frequencies = new int[m + 1]; // Array para armazenar frequências
        int count = 0; // Contador de números lidos

        // Lê os valores de entrada e conta a frequência de cada um
        while (!StdIn.isEmpty()) {
            int valor = StdIn.readInt();
            if (valor >= 1 && valor <= m) {
                frequencies[valor]++;
                count++;
            }
        }

        double entropy = 0.0;
        // Calcula a entropia de Shannon
        for (int i = 1; i <= m; i++) {
            double pi = (double) frequencies[i] / count;
            if (frequencies[i] > 0) {
                entropy -= pi * (Math.log(pi) / Math.log(2));
            }
        }

        // Exibe a entropia com 4 casas decimais
        StdOut.printf("%.4f\n", entropy);
    }
}

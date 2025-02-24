public class GeneralizedHarmonic {
    public static void main(String[] args) {
        // Lê os argumentos da linha de comando
        int n = Integer.parseInt(args[0]); // Número de termos da série
        int r = Integer.parseInt(args[1]); // Expoente da série harmônica generalizada

        // Se n for menor ou igual a zero, encerra o programa
        if (n <= 0)
            return;

        double harmonic = 0.0; // Variável para armazenar o valor da soma

        // Calcula a soma harmônica generalizada
        for (int i = 1; i <= n; i++) {
            harmonic += 1 / Math.pow(i, r);
        }

        // Exibe o resultado final
        System.out.println(harmonic);
    }
}

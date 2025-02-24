public class BandMatrix {
    public static void main(String[] args) {
        // Lê os argumentos da linha de comando
        int n = Integer.parseInt(args[0]);    // Dimensão da matriz (n x n)
        int width = Integer.parseInt(args[1]); // Largura da banda diagonal

        // Percorre as linhas da matriz
        for (int i = 0; i < n; i++) {
            // Percorre as colunas da matriz
            for (int j = 0; j < n; j++) {
                // Adiciona espaço entre os elementos, exceto no primeiro da linha
                if (j != 0)
                    System.out.print(" ");

                // Verifica se a posição está dentro da banda diagonal
                if (Math.abs(j - i) > width) {
                    System.out.print("0");  // Fora da banda, imprime '0'
                } else {
                    System.out.print("*");  // Dentro da banda, imprime '*'
                }
            }
            // Quebra de linha para a próxima linha da matriz
            System.out.println();
        }
    }
}

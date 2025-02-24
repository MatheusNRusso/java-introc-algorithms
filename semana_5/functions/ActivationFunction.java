public class ActivationFunction {

    /**
     * Função Heaviside (ou função degrau).
     * - Retorna 0.0 se x < 0.
     * - Retorna 0.5 se x == 0.
     * - Retorna 1.0 se x > 0.
     * - Se x for NaN (Not a Number), retorna NaN.
     */
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN; // Verifica se x é NaN.
        if (x < 0) return 0.0; // Retorna 0.0 para valores negativos.
        if (x == 0) return 0.5; // Retorna 0.5 para x igual a zero.
        return 1.0; // Retorna 1.0 para valores positivos.
    }

    /**
     * Função Sigmoid (ou função logística).
     * - Fórmula: f(x) = 1 / (1 + e^(-x)).
     * - Retorna um valor entre 0 e 1.
     * - Se x for NaN, retorna NaN.
     */
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN; // Verifica se x é NaN.
        return 1 / (1 + Math.exp(-x)); // Calcula a função sigmoid.
    }

    /**
     * Função Tangente Hiperbólica (tanh).
     * - Fórmula: tanh(x) = (e^x - e^(-x)) / (e^x + e^(-x)).
     * - Retorna um valor entre -1 e 1.
     * - Se x for NaN, retorna NaN.
     */
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN; // Verifica se x é NaN.
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x)); // Calcula tanh(x).
    }

    /**
     * Função Softsign.
     * - Fórmula: softsign(x) = x / (1 + |x|).
     * - Retorna um valor entre -1 e 1.
     * - Se x for NaN, retorna NaN.
     */
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN; // Verifica se x é NaN.
        return x / (1 + Math.abs(x)); // Calcula a função softsign.
    }

    /**
     * Função SQNL (Scaled Quadratic Nonlinearity).
     * - Fórmula:
     *   - Se x <= -2, retorna -1.0.
     *   - Se -2 < x < 0, retorna x + (x^2)/4.
     *   - Se 0 <= x < 2, retorna x - (x^2)/4.
     *   - Se x >= 2, retorna 1.0.
     * - Se x for NaN, retorna NaN.
     */
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN; // Verifica se x é NaN.
        if (x <= -2) return -1.0; // Retorna -1.0 para x <= -2.
        if (x < 0) return x + (x * x) / 4; // Calcula para -2 < x < 0.
        if (x < 2) return x - (x * x) / 4; // Calcula para 0 <= x < 2.
        return 1.0; // Retorna 1.0 para x >= 2.
    }

    /**
     * Método principal que lê um valor da linha de comando e aplica as funções de ativação.
     * - Verifica se o número de argumentos é correto.
     * - Converte o argumento para um número válido.
     * - Aplica todas as funções de ativação ao valor fornecido e imprime os resultados.
     */
    public static void main(String[] args) {
        // Verifica se foi fornecido exatamente um argumento.
        if (args.length != 1) {
            System.out.println("Usage: java ActivationFunction <value>");
            return;
        }

        double x;
        try {
            // Tenta converter o argumento para um número.
            x = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            // Se a conversão falhar, imprime uma mensagem de erro.
            System.out.println("Invalid input. Please provide a valid number.");
            return;
        }

        // Aplica cada função de ativação ao valor fornecido e imprime os resultados.
        System.out.printf("heaviside(%.2f) = %.2f%n", x, heaviside(x));
        System.out.printf("sigmoid(%.2f) = %.2f%n", x, sigmoid(x));
        System.out.printf("tanh(%.2f) = %.2f%n", x, tanh(x));
        System.out.printf("softsign(%.2f) = %.2f%n", x, softsign(x));
        System.out.printf("sqnl(%.2f) = %.2f%n", x, sqnl(x));
    }
}

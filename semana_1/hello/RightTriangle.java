public class RightTriangle {
    public static void main(String[] args) {
        // Lê os três valores inteiros fornecidos como argumentos
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        // Verifica se os valores formam um triângulo retângulo usando o Teorema de Pitágoras
        boolean triangulo = c * c == a * a + b * b ||
                b * b == a * a + c * c ||
                a * a == b * b + c * c;

        // Garante que todos os valores sejam positivos e exibe o resultado
        System.out.println(a > 0 && b > 0 && c > 0 && triangulo);
    }
}

public class Divisors {

    // Retorna o maior divisor comum (MDC) de a e b.
    public static int gcd(int a, int b) {
        if (a == 0 && b == 0) return 0; // Caso especial
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    // Retorna o mínimo múltiplo comum (MMC) de a e b.
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs((long) a * b / gcd(a, b)); // Evita overflow na multiplicação
    }

    // Retorna verdadeiro se a e b forem primos entre si (MDC = 1).
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Retorna o número de inteiros entre 1 e n que são primos relativos a n (função totiente de Euler).
    public static int totient(int n) {
        if (n <= 0) return 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (areRelativelyPrime(i, n)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ") = " + totient(a));
        System.out.println("totient(" + b + ") = " + totient(b));
    }
}

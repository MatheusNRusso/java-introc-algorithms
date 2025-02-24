public class Inversions {

    // Retorna o número de inversões na permutação a[].
    public static long count(int[] a)
    {
        int nPerm = a.length;
        long inversions = 0;

        for (int i = 0; i < nPerm; i++)
        {
            for (int j = i + 1; j < nPerm; j++)
            {
                if (a[i] > a[j])
                {
                    inversions++;
                }
            }
        }
        return inversions;
    }

    // Retorna uma permutação de comprimento n com exatamente k inversões.
    public static int[] generate(int n, long k)
    {
        int[] permutation = new int[n];
        int deslocaLeft = 0;
        int deslocaRight = n - 1;

        for (int i = 0; i < n; i++)
        {
            int alvo = (deslocaRight - deslocaLeft);
            if (k >= alvo)
            {
                permutation[i] = deslocaRight--;
                k -= alvo;
            }
            else
            {
                permutation[i] = deslocaLeft++;
            }
        }
        return permutation;
    }


    // Recebe um inteiro n e um long k como argumentos da linha de comando,
    // e imprime uma permutação de comprimento n com exatamente k inversões.
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] permutation = generate(n, k);
        for (int i = 0; i < permutation.length; i++)
        {
            StdOut.print(permutation[i] + " ");
        }
    }
}

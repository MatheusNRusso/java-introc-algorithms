public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // Número total de dias possíveis para aniversários
        int trials = Integer.parseInt(args[1]); // Número de simulações
        int i = 1;
        double fraction = 0;
        double[] peopleCount = new double[n + 2];

        // Simulações até que a probabilidade de coincidência atinja 50%
        while (fraction < 0.50 && i <= n) {
            for (int j = 0; j < trials; j++) {
                int found = 0;
                boolean[] birthArr = new boolean[n]; // Array para marcar aniversários já escolhidos
                int enterPeople = 1;

                while (enterPeople < i + 1) {
                    int birthday = (int) (Math.random() * n); // Escolhe um aniversário aleatório
                    enterPeople++;

                    if (!birthArr[birthday]) birthArr[birthday] = true;
                    else found++; // Se já existia esse aniversário, há uma coincidência
                }
                peopleCount[i] += found;
            }
            fraction = peopleCount[i] / trials;
            System.out.println(i + "\t" + (int) (peopleCount[i] - peopleCount[i - 1]) + "\t" + fraction);
            i++;
        }
    }
}


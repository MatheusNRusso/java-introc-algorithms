public class AudioCollage {

    // Retorna um novo array que amplifica os valores de 'a' por um fator 'alpha'.
    public static double[] amplify(double[] a, double alpha) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * alpha;
        }
        return result;
    }

    // Retorna um novo array que é a versão invertida de 'a'.
    public static double[] reverse(double[] a) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[a.length - 1 - i];
        }
        return result;
    }

    // Retorna um novo array que é a concatenação de 'a' e 'b'.
    public static double[] concatenate(double[] a, double[] b) {
        double[] result = new double[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    // Retorna um novo array que é a soma de 'a' e 'b', preenchendo arrays menores com zeros.
    public static double[] merge(double[] a, double[] b) {
        int maxLength = Math.max(a.length, b.length);
        double[] result = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            double sample1 = (i < a.length) ? a[i] : 0.0;
            double sample2 = (i < b.length) ? b[i] : 0.0;
            result[i] = sample1 + sample2;
        }
        return result;
    }

    // Retorna um novo array que altera a velocidade do áudio por um fator 'alpha'.
    public static double[] changeSpeed(double[] a, double alpha) {
        int newLength = (int) (a.length / alpha);
        double[] result = new double[newLength];

        for (int i = 0; i < newLength; i++) {
            int index = Math.min((int) (i * alpha), a.length - 1); // Evita index inválido
            result[i] = a[index];
        }
        return result;
    }

    public static void main(String[] args) {
        // Carrega áudios WAV usando StdAudio.read().
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] piano = StdAudio.read("piano.wav");

        // Criação de efeitos.
        double[] amplified = amplify(beatbox, 1.5);
        double[] reversed = reverse(chimes);
        double[] merged = merge(harp, buzzer);
        double[] mixed = merge(piano, reversed); // Uso correto de `merge` para soma
        double[] spedUp = changeSpeed(beatbox, 2.0);

        // Colagem de áudio: combinação de efeitos.
        double[] collage = concatenate(amplified, mixed);
        collage = concatenate(collage, merged);
        collage = concatenate(collage, spedUp);

        // Reproduz a colagem criada.
        StdAudio.play(collage);
    }
}

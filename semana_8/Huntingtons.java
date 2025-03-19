public class Huntingtons {

    public static int maxRepeats(String dna) {
        int maxCount = 0;
        int count = 0;
        int i = 0;

        while (i <= dna.length() - 3) {
            if (dna.substring(i, i + 3).equals("CAG")) {
                count++;
                i += 3;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
                i++;
            }
        }
        return Math.max(maxCount, count);
    }

    public static String removeWhitespace(String s) {
        return s.replace(" ", "").replace("\n", "").replace("\t", "");
    }

    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9) return "not human";
        if (maxRepeats <= 35) return "normal";
        if (maxRepeats <= 39) return "high risk";
        if (maxRepeats <= 180) return "Huntington's";
        return "not human";
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Huntingtons <filename>");
            return;
        }

        In in = new In(args[0]);
        String dna = removeWhitespace(in.readAll());

        int maxRepeats = maxRepeats(dna);
        System.out.println("max repeats = " + maxRepeats);
        System.out.println(diagnose(maxRepeats));
    }
}

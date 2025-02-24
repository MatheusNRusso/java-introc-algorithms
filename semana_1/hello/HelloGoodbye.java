public class HelloGoodbye {
    public static void main(String[] args) {
        // Obtém os nomes passados como argumentos de linha de comando
        String a = args[0];
        String b = args[1];

        // Exibe mensagem de saudação e despedida, trocando a ordem dos nomes
        System.out.println("Hello " + a + " and " + b + ".");
        System.out.println("Goodbye " + b + " and " + a + ".");
    }
}

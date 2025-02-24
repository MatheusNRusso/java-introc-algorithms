public class CMYKtoRGB {
	public static void main(String args[]) {
		// Converte os valores CMYK fornecidos como argumentos para números de ponto flutuante
		double cyan = Double.parseDouble(args[0]);
		double magenta = Double.parseDouble(args[1]);
		double yellow = Double.parseDouble(args[2]);
		double black = Double.parseDouble(args[3]);

		// Calcula a cor branca com base no valor de preto
		double white = 1 - black;

		// Converte os valores CMYK para RGB usando a fórmula apropriada
		int red = (int) Math.round(255 * (1 - cyan));
		int green = (int) Math.round(255 * (1 - magenta));
		int blue = (int) Math.round(255 * (1 - yellow));

		// Exibe os valores de cor RGB resultantes
		System.out.println("red = " + red);
		System.out.println("green = " + green);
		System.out.println("blue = " + blue);
	}
}

public class GreatCircle {
	public static void main(String args[]) {
		// Converte as coordenadas geográficas fornecidas de graus para radianos
		double x1 = Math.toRadians(Double.parseDouble(args[0]));
		double y1 = Math.toRadians(Double.parseDouble(args[1]));
		double x2 = Math.toRadians(Double.parseDouble(args[2]));
		double y2 = Math.toRadians(Double.parseDouble(args[3]));

		// Calcula a distância entre dois pontos na esfera usando a fórmula do círculo máximo
		double s0 = Math.pow(Math.sin((x2 - x1) / 2.0), 2);
		double s1 = Math.pow(Math.sin((y2 - y1) / 2.0), 2) * Math.cos(x1) * Math.cos(x2);
		double sqrt = Math.sqrt(s0 + s1);

		// Raio médio da Terra em quilômetros
		double r = 6371.0;

		// Calcula a distância final e exibe o resultado
		double distance = 2 * r * Math.asin(sqrt);
		System.out.println(distance + " kilometers");
	}
}

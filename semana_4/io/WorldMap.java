public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt(); // Largura do mapa
        int height = StdIn.readInt(); // Altura do mapa

        // Define as dimensões da tela
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        // Lê e desenha regiões do mapa
        while (!StdIn.isEmpty()) {
            String region = StdIn.readString(); // Nome da região (não utilizado no desenho)
            int vertices = StdIn.readInt(); // Número de vértices da região
            double[] x = new double[vertices];
            double[] y = new double[vertices];

            // Lê as coordenadas dos vértices
            for (int i = 0; i < vertices; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }

            // Desenha o polígono correspondente à região
            StdDraw.polygon(x, y);
        }

        StdDraw.show(); // Mostra o desenho final
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BarChartRacer {

    public static void main(String[] args) {
        String filename = args[0];
        int k = Integer.parseInt(args[1]);

        In in = new In(filename);
        String title = in.readLine();
        String xAxisLabel = in.readLine();
        String dataSource = in.readLine();

        BarChart chart = new BarChart(title, xAxisLabel, dataSource);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        while (in.hasNextLine()) {
            String line = in.readLine();
            if (line == null || line.isEmpty()) continue;

            int n = Integer.parseInt(line);
            List<Bar> bars = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String record = in.readLine();
                if (record == null || record.isEmpty()) continue;

                String[] fields = record.split(",");
                String name = fields[1];
                int value = Integer.parseInt(fields[3]);
                String category = fields[4];

                bars.add(new Bar(name, value, category));
            }

            // Ordenar do maior para o menor
            Collections.sort(bars);
            Collections.reverse(bars);

            chart.reset();
            for (int i = 0; i < Math.min(k, bars.size()); i++) {
                Bar bar = bars.get(i);
                chart.add(bar.getName(), bar.getValue(), bar.getCategory());
            }

            chart.setCaption(line);
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
        }
    }
}

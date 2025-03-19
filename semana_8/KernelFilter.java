import java.awt.Color; // Specific import instead of java.awt.*

public class KernelFilter {

    // Helper method to apply a kernel to a picture
    private static Picture applyKernel(Picture picture, double[][] kernel) {
        int width = picture.width();
        int height = picture.height();
        Picture result = new Picture(width, height);

        int kernelSize = kernel.length;
        int radius = kernelSize / 2;

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                double r = 0.0, g = 0.0, b = 0.0;

                // Apply the kernel to the pixel
                for (int i = 0; i < kernelSize; i++) {
                    for (int j = 0; j < kernelSize; j++) {
                        int x = (col - radius + i + width) % width; // Periodic boundary
                        int y = (row - radius + j + height) % height; // Periodic boundary
                        Color color = picture.get(x, y);
                        double weight = kernel[i][j];
                        r += color.getRed() * weight;
                        g += color.getGreen() * weight;
                        b += color.getBlue() * weight;
                    }
                }

                // Round and clamp the resulting RGB values
                int red = clamp((int) Math.round(r));
                int green = clamp((int) Math.round(g));
                int blue = clamp((int) Math.round(b));

                result.set(col, row, new Color(red, green, blue));
            }
        }

        return result;
    }

    // Clamp the value to the range [0, 255]
    private static int clamp(int value) {
        return Math.min(255, Math.max(0, value));
    }

    // Identity filter
    public static Picture identity(Picture picture) {
        double[][] kernel = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        return applyKernel(picture, kernel);
    }

    // Gaussian blur filter
    public static Picture gaussian(Picture picture) {
        double[][] kernel = {
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1}
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                kernel[i][j] /= 16.0;
            }
        }
        return applyKernel(picture, kernel);
    }

    // Sharpen filter
    public static Picture sharpen(Picture picture) {
        double[][] kernel = {
                {0, -1, 0},
                {-1, 5, -1},
                {0, -1, 0}
        };
        return applyKernel(picture, kernel);
    }

    // Laplacian filter
    public static Picture laplacian(Picture picture) {
        double[][] kernel = {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1}
        };
        return applyKernel(picture, kernel);
    }

    // Emboss filter
    public static Picture emboss(Picture picture) {
        double[][] kernel = {
                {-2, -1, 0},
                {-1, 1, 1},
                {0, 1, 2}
        };
        return applyKernel(picture, kernel);
    }

    // Motion blur filter
    public static Picture motionBlur(Picture picture) {
        double[][] kernel = new double[9][9];
        for (int i = 0; i < 9; i++) {
            kernel[i][i] = 1.0 / 9.0;
        }
        return applyKernel(picture, kernel);
    }

    // Test client
    public static void main(String[] args) {
        Picture picture = new Picture("baboon.png");

        Picture identity = identity(picture);
        identity.show();

        Picture gaussian = gaussian(picture);
        gaussian.show();

        Picture sharpen = sharpen(picture);
        sharpen.show();

        Picture laplacian = laplacian(picture);
        laplacian.show();

        Picture emboss = emboss(picture);
        emboss.show();

        Picture motionBlur = motionBlur(picture);
        motionBlur.show();
    }
}

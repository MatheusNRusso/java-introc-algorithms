public class ColorHSB {

    private int hue;
    private int saturation;
    private int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b)
    {
        if (h < 0 || h > 359)
            throw new IllegalArgumentException("h value must be between 0 and 359");
        if (s < 0 || s > 100)
            throw new IllegalArgumentException("s value must be between 0 and 100");
        if (b < 0 || b > 100)
            throw new IllegalArgumentException("b value must be between 0 and 100");

        this.hue = h;
        this.saturation = s;
        this.brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString()
    {
        return "(" + hue + "," + saturation + "," + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale()
    {
        return (saturation == 0 || brightness == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that)
    {
        if (that == null)
            throw new IllegalArgumentException("ColorHSB cannot be null");
        int hueDiff = Math.abs(this.hue-that.hue);
        int minHueDiff = Math.min(hueDiff, 360 - hueDiff);
        int hueDistance = minHueDiff * minHueDiff;

        int satDistance = (this.saturation - that.saturation) * (this.saturation - that.saturation);
        int briDistance = (this.brightness - that.brightness) * (this.brightness - that.brightness);

        return hueDistance + satDistance + briDistance;
    }

    // Sample client (see below).
    public static void main(String[] args)
    {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB hsb = new ColorHSB(h, s, b);

        String closestName = null;
        ColorHSB closestColor = null;
        int minDistance = Integer.MAX_VALUE;

        while (!StdIn.isEmpty())
        {
            String name = StdIn.readString();
            int hue = StdIn.readInt();
            int saturation = StdIn.readInt();
            int brightness = StdIn.readInt();

            ColorHSB color = new ColorHSB(hue, saturation, brightness);
            int distance = hsb.distanceSquaredTo(color);

            if (distance < minDistance) {
                minDistance = distance;
                closestName = name;
                closestColor = color;
            }

        }
        StdOut.println(closestName + " " + closestColor);

    }

}
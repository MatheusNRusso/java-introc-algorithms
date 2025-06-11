public class Clock {

    private int hour;
    private int minute;
    private String time;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m)
    {
        if (h < 0 || h > 23)
            throw new IllegalArgumentException("Hour must be between 0 and 23");

        if (m < 0 || m > 59)
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        this.hour = h;
        this.minute = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s)
    {
        if (s == null || s.length() != 5 || s.charAt(2) != ':')
            throw new IllegalArgumentException("Invalid time format");
        try
        {
            int h = Integer.parseInt(s.substring(0, 2));
            int m = Integer.parseInt(s.substring(3, 5));

            if (h < 0 || h > 23 || m < 0 || m > 59)
                throw new IllegalArgumentException("Hour must be between 0 and 23");

            this.hour = h;
            this.minute = m;
        }
        catch (NumberFormatException e)
        {
            throw new IllegalArgumentException("Invalid time format");
        }
    }
    // Returns a string representation of this clock, using the format HH:MM.
    public String toString()
    {
        return String.format("%02d:%02d", hour, minute);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hour < that.hour) return true;
        if (this.hour > that.hour) return false;
        return this.minute < that.minute;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        this.minute++;
        if (this.minute == 60) {
            this.minute = 0;
            this.hour = (this.hour + 1) % 24;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("Delta must be non-negative");

        int totalMinutes = this.hour * 60 + this.minute + delta;
        totalMinutes %= (24 * 60);

        this.hour = totalMinutes / 60;
        this.minute = totalMinutes % 60;
    }

    // Test client
    public static void main(String[] args) {
        // Test constructor with int
        Clock c1 = new Clock(23, 59);
        System.out.println("c1: " + c1);

        // Test constructor with string
        Clock c2 = new Clock("00:00");
        System.out.println("c2: " + c2);

        // Test isEarlierThan
        System.out.println("c1 earlier than c2? " + c1.isEarlierThan(c2));

        // Test tic
        c1.tic();
        System.out.println("c1 after tic: " + c1);

        // Test toc
        c2.toc(61);
        System.out.println("c2 after toc(61): " + c2);

        // Test isEarlierThan again
        System.out.println("c1 earlier than c2? " + c1.isEarlierThan(c2));
    }
}

/**
 * Represents a bar with a name, value, and category.
 * Immutable and comparable by value.
 */
public class Bar implements Comparable<Bar> {
    private final String name;
    private final int value;
    private final String category;

    /**
     * Constructs a Bar object with the specified name, value, and category.
     *
     * @param name     the name of the bar (non-null)
     * @param value    the value of the bar (non-negative)
     * @param category the category of the bar (non-null)
     * @throws IllegalArgumentException if name or category is null, or if value is negative
     */
    public Bar(String name, int value, String category) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative.");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null.");
        }

        this.name = name;
        this.value = value;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }

    /**
     * Compares this Bar to another based on the value.
     *
     * @param that another Bar object
     * @return a negative integer, zero, or a positive integer if this value
     *         is less than, equal to, or greater than the specified object's value
     * @throws NullPointerException if the specified object is null
     */
    @Override
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException("Cannot compare to a null Bar object.");
        }
        return Integer.compare(this.value, that.value);
    }


    @Override
    public String toString() {
        return String.format("Bar{name='%s', value=%d, category='%s'}", name, value, category);
    }

    // Aqui está o main para testes básicos
    public static void main(String[] args) {
        Bar b1 = new Bar("Tokyo", 38194, "East Asia");
        Bar b2 = new Bar("Mexico City", 21520, "Latin America");
        Bar b3 = new Bar("Cairo", 1500, "Middle East");

        System.out.println("Name: " + b1.getName() + ", Value: " + b1.getValue() + ", Category: " + b1.getCategory());
        System.out.println("Name: " + b2.getName() + ", Value: " + b2.getValue() + ", Category: " + b2.getCategory());
        System.out.println("Name: " + b3.getName() + ", Value: " + b3.getValue() + ", Category: " + b3.getCategory());

        // Comparar dois bars
        System.out.println("Comparing Tokyo and Mexico City: " + b1.compareTo(b2));
    }
}

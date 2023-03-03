package core.basesyntax.model;

public class Fruit {
    private static final int FIRST_PRIME = 17;
    private static final int SECOND_PRIME = 31;

    private String name;
    private int quantity;

    public Fruit() {
    }

    public Fruit(String name) {
        this.name = name;
    }

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object fruit) {
        if (this == fruit) {
            return true;
        }
        if (fruit == null || getClass() != fruit.getClass()) {
            return false;
        }

        Fruit fruit1 = (Fruit) fruit;
        return (fruit1.name == this.name
                || (fruit1.name != null && fruit1.name.equals(this.name)))
                && fruit1.quantity == this.quantity;
    }

    public int hashCode() {
        int result = FIRST_PRIME;
        result = SECOND_PRIME * result + (name == null ? 0 : name.hashCode());
        result = SECOND_PRIME * result + quantity;
        return result;
    }
}

package core.basesyntax.model;

public class Fruit {
    private String name;
    private int quantity;

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Fruit fruit = (Fruit) o;

        if (quantity != fruit.quantity) {
            return false;
        }
        return name != null ? name.equals(fruit.name) : fruit.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}

package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private int quantity;
    private String name;

    public Fruit(FruitBuilder builder) {
        this.quantity = builder.quantity;
        this.name = builder.name;
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

    public static class FruitBuilder {
        private int quantity;
        private String name;

        public FruitBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public FruitBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Fruit build() {
            return new Fruit(this);
        }
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
        return Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

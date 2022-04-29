package model;

public final class Product {
    private final String nameOfFruit;

    public Product(String nameOfFruit) {
        this.nameOfFruit = nameOfFruit;
    }

    public String getNameOfFruit() {
        return nameOfFruit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Product product = (Product) o;

        return nameOfFruit.equals(product.nameOfFruit);
    }

    @Override
    public int hashCode() {
        return nameOfFruit.hashCode();
    }

    @Override
    public String toString() {
        return nameOfFruit;
    }
}

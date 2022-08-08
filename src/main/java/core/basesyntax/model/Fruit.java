package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private final String nameFruit;
    private Integer quantityFruits;

    public Fruit(String nameFruit, Integer quantityFruits) {
        this.nameFruit = nameFruit;
        this.quantityFruits = quantityFruits;
    }

    public String getName() {
        return nameFruit;
    }

    public Integer getAmountFruit() {
        return quantityFruits;
    }

    public void setAmountFruit(Integer quantityFruits) {
        this.quantityFruits = quantityFruits;
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
        return Objects.equals(nameFruit, fruit.nameFruit)
                && Objects.equals(quantityFruits, fruit.quantityFruits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameFruit, quantityFruits);
    }
}

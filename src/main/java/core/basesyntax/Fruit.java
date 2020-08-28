package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fruit {
    private static List<Fruit> fruitAvailable = new ArrayList<>();
    private String typeOfFruit;
    private String expirationDate;

    public Fruit(String typeOfFruit, String expirationDate) {
        this.typeOfFruit = typeOfFruit;
        this.expirationDate = expirationDate;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public void setTypeOfFruit(String typeOfFruit) {
        this.typeOfFruit = typeOfFruit;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public List<Fruit> getFruitTypes() {
        return fruitAvailable;
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
        return Objects.equals(typeOfFruit, fruit.typeOfFruit)
                && Objects.equals(expirationDate, fruit.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfFruit, expirationDate);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "typeOfFruit='" + typeOfFruit + '\''
                + ", expirationDate='" + expirationDate + '\''
                + '}';
    }
}

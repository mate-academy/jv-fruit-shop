package core.basesyntax;

import core.basesyntax.model.Fruit;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Storage {
    private List<FruitBox> boxes = new ArrayList<>();

    public void add(Fruit fruit, int quantity) {
        Optional<FruitBox> fruitBox = boxes.stream()
                .filter(x -> x.getFruit().getName().equals(fruit.getName()))
                .filter(x -> x.getFruit().getShelfLife().equals(fruit.getShelfLife()))
                .findFirst();
        fruitBox.ifPresentOrElse(x -> x.setQuantity(x.getQuantity() + quantity),
                () -> boxes.add(new FruitBox(fruit, quantity)));
    }

    public void remove(Fruit fruit, int quantity) {
        List<FruitBox> fruitBoxes = boxes.stream()
                .filter(x -> x.getFruit().getName().equals(fruit.getName()))
                .sorted()
                .collect(Collectors.toList());
        int quantitiesSum = fruitBoxes.stream()
                .mapToInt(FruitBox::getQuantity)
                .sum();
        if (quantitiesSum < quantity) {
            throw new InvalidParameterException();
        }
        int index = 0;
        while (quantity > 0) {
            FruitBox tempFruitBox = fruitBoxes.get(index);
            int tempQuantity = tempFruitBox.quantity;
            if (quantity > tempFruitBox.quantity) {
                boxes.remove(tempFruitBox);
            } else {
                tempFruitBox.setQuantity(tempFruitBox.quantity - quantity);
            }
            quantity -= tempQuantity;
            index++;
        }
    }

    public List<FruitBox> getAll() {
        return boxes.stream()
                .map(FruitBox::clone)
                .collect(Collectors.toList());
    }

    public int size() {
        return boxes.size();
    }

    public void clear() {
        boxes.clear();
    }

    public static class FruitBox implements Cloneable, Comparable<FruitBox> {
        private Fruit fruit;
        private int quantity;

        public FruitBox(Fruit fruit, int quantity) {
            this.fruit = fruit;
            this.quantity = quantity;
        }

        public Fruit getFruit() {
            return fruit;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        public FruitBox clone() {
            return new FruitBox(fruit, quantity);
        }

        @Override
        public int compareTo(FruitBox o) {
            return this.fruit.getShelfLife().compareTo(o.getFruit().getShelfLife());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            FruitBox fruitBox = (FruitBox) o;
            return quantity == fruitBox.quantity
                    && Objects.equals(fruit, fruitBox.fruit);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fruit, quantity);
        }
    }
}

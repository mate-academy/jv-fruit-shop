package core.basesyntax;

import java.util.List;
import java.util.stream.Collectors;

public class Buy extends Operation {
    @Override
    public void toDo(Fruit fruit, Storage storage) {
        List<Fruit> availableFruits = storage.getFruits()
                .stream()
                .filter(position -> position.getType().equals(fruit.getType())
                        && (position.getDate().isAfter(fruit.getDate())
                        || position.getDate().isEqual(fruit.getDate())))
                .collect(Collectors.toList());
        if (availableFruits.size() == 0) {
            throw new IllegalArgumentException("We don't have such type of fresh fruits");
        }
        int totalAmount = fruit.getAmount();
        int availableAmountOfFruits = availableFruits
                .stream()
                .mapToInt(Fruit::getAmount)
                .sum();
        if (availableAmountOfFruits < totalAmount) {
            throw new IllegalArgumentException("We don't have so much fresh fruits of this type");
        }
        Fruit firstFruit = availableFruits.get(0);
        if (firstFruit.getAmount() > totalAmount) {
            firstFruit.setAmount(firstFruit.getAmount() - totalAmount);
        } else {
            while (totalAmount > 0) {
                if (totalAmount >= firstFruit.getAmount()) {
                    availableFruits.remove(firstFruit);
                    storage.getFruits().remove(firstFruit);
                    totalAmount = totalAmount - firstFruit.getAmount();
                    firstFruit = availableFruits.get(0);
                } else {
                    firstFruit.setAmount(firstFruit.getAmount() - totalAmount);
                    totalAmount = 0;
                }
            }
        }
    }
}

package core.basesyntax.model;

import java.time.LocalDate;

public class CreateStrategyImpl implements CreateStrategy {
    @Override
    public Fruit createFruit(String fruitType, LocalDate expirationDate) {
        if (fruitType.equalsIgnoreCase(Banana.class.getSimpleName())) {
            return new Banana(expirationDate);
        } else if (fruitType.equalsIgnoreCase(Apple.class.getSimpleName())) {
            return new Apple(expirationDate);
        } else if (fruitType.equalsIgnoreCase(Orange.class.getSimpleName())) {
            return new Orange(expirationDate);
        } else {
            throw new IllegalArgumentException();
        }
    }
}

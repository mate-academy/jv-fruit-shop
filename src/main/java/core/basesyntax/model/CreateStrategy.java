package core.basesyntax.model;

import java.time.LocalDate;

public interface CreateStrategy<T extends Fruit> {
    T createFruit(String fruitType, LocalDate expirationDate);
}

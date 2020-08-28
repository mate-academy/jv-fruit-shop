package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.time.LocalDate;
import java.util.List;

public interface FruitService {

    boolean add(Fruit fruit);

    void sell(String fruitName, LocalDate expirationDate, int amount);

    List<Fruit> getAll();
}

package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface DataProcessService {
    int countFruit(List<FruitTransaction> fruits, String fruitName);
}

package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface AmountOfFruitsFromFile {
    List<Integer> getAmountOfFruitsFromFile(List<String> fruits, List<FruitTransaction> fruitTransactions);
}

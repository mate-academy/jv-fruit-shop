package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionParser {
    List<FruitTransaction> parsOf(List<String> fruits);
    List<FruitTransaction> getListFruit();
}

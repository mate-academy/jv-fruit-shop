package java.core.basesyntax.service;

import java.util.List;
import java.core.basesyntax.model.FruitTransaction;

public interface Parser {
    FruitTransaction parse(String data);

    List<FruitTransaction> convertFruitDataToTransactions(List<String> fruitData);
}

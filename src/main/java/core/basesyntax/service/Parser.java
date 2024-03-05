package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Parser {
    FruitTransaction parse(String data);

    List<FruitTransaction> convertFruitDataToTransactions(List<String> fruitData);
}

package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public interface ReadDataProcessor {
    List<FruitTransaction> parseToTransactionList(List<String> readData);
}

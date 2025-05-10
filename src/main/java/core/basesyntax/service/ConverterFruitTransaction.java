package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConverterFruitTransaction {
    List<FruitTransaction> convertToFruitTransaction(List<String> readFruitTransaction);
}

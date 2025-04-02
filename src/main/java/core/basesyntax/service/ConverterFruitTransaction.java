package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConverterFruitTransaction {
    List<FruitTransaction> converterFruitTransaction(List<String> readFruitTransaction);
}

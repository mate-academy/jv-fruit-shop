package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface DataConverterMethods {
    List<FruitTransaction> convertToTransaction(List<String> readedFruits);
}

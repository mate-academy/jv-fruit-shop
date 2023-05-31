package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConverterDataService {
    List<FruitTransaction> convertForTransaction(List<String> strings);
}

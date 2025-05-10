package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataConverterService {
    List<FruitTransaction> convertToTransaction(List<String> fruitInfoList);
}

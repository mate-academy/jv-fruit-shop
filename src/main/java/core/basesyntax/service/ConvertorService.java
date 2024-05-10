package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConvertorService {
    List<FruitTransaction> convertData(List<String> inputList);
}

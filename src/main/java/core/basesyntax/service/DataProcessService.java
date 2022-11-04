package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcessService {
    List<FruitTransaction> processData(List<String> inputData);
}

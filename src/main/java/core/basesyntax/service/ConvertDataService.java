package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ConvertDataService {

    List<FruitTransaction> processingData(List<String> fruits);
}

package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitStorageCheckService {

    Map<String, Integer> checkStorage(List<FruitTransaction> fruitTransactions);
}

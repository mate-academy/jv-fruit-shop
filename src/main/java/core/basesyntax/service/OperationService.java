package core.basesyntax.service;

import core.basesyntax.model.FruitShopTransactions;
import java.util.List;

public interface OperationService {
    void processData(List<FruitShopTransactions> fruitTransactions);
}

package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitService {
    void transactions(FruitDao fruitDao, List<FruitTransaction> fruits,
                      OperationStrategy operationStrategy);
}

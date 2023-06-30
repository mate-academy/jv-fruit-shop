package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.dataservice.DataService;

public interface DataServiceStrategy {
    DataService get(FruitTransaction.Operation operationType);
}

package core.basesyntax.DataService;

import core.basesyntax.tranasctions.FruitTransaction;
import core.basesyntax.tranasctions.OperationStrategy;

import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}

package core.basesyntax.dataservice;

import core.basesyntax.transactions.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}

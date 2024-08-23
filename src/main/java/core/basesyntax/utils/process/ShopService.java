package core.basesyntax.utils.process;

import core.basesyntax.utils.transaction.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}

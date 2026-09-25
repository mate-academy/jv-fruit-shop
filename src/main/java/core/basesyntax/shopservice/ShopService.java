package core.basesyntax.shopservice;

import core.basesyntax.fruittransaction.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> operations);
}

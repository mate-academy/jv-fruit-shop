package core.basesyntax.service;

import core.basesyntax.model.FruitTransactionImpl;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransactionImpl> transactions);
}

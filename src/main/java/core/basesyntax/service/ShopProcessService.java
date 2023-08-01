package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ShopProcessService {
    void processData(List<FruitTransaction> transaction);
}

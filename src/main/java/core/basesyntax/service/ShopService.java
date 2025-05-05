package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.math.BigDecimal;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> fruitTransactions);
}

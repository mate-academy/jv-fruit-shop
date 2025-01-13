package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface ShopService {
    public void process(List<FruitTransaction> transactions);
}

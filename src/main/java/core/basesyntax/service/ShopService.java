package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ShopService {
    void addFruit(String fruit, int quantity);

    int getFruitQuantity(String fruit);

    void process(List<FruitTransaction> transactions);
}

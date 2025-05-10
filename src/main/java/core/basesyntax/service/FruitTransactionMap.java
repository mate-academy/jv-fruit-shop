package core.basesyntax.service;

import core.basesyntax.model.ShopTransaction;
import java.util.List;

public interface FruitTransactionMap {
    List<ShopTransaction> map(List<String> dataFromFile);
}

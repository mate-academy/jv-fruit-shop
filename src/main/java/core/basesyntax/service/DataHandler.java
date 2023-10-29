package core.basesyntax.service;

import core.basesyntax.data.FruitTransaction;
import java.util.List;

public interface DataHandler {
    public void handler(List<FruitTransaction> fruitDataList);
}

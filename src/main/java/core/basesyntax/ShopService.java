package core.basesyntax;

import java.util.List;
import model.FruitTransaction;

public interface ShopService {
    void process(List<FruitTransaction> fruitTransactionList);
}

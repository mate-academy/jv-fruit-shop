package core.basesyntax.service.fruitshop;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitShopService {
    List<FruitTransaction> readAllFromCsv();

    void exportReport();

    void balance(String fruit, int quantity);

    void supply(String fruit, int quantity);

    void purchase(String fruit, int quantity);

    void returnFruits(String fruit, int quantity);
}

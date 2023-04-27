package core.basesyntax.service.fruitshop;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitShopService {
    List<FruitTransaction> readAllFromCsv();

    void exportReport();

    int balance(String fruit, int quantity);

    int supply(String fruit, int quantity);

    int purchase(String fruit, int quantity);

    int returnFruits(String fruit, int quantity);
}

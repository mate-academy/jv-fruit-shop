package core.basesyntax.fruitshop.service;

import core.basesyntax.fruitshop.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitShopService {
    List<FruitTransaction> parseTransactions(List<String> lines);

    Map<String, Integer> processTransactions(List<FruitTransaction> transactions);
}

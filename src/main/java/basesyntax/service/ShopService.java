package basesyntax.service;

import basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ShopService {
    Map<String, Integer> process(List<FruitTransaction> transactions);
}

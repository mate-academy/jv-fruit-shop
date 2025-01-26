package core.basesyntax.Service;

import core.basesyntax.Model.FruitTransaction;

import java.util.List;
import java.util.Map;

public interface ShopService {
    Map<String, Integer> process(List<FruitTransaction> transactions);
}

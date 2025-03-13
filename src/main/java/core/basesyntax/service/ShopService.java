package core.basesyntax.service;

import java.util.List;

public interface ShopService {
    List<FruitStorage> process(List<FruitTransaction> transactions);
}

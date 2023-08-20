package core.basesyntax.model;

import java.util.List;

public interface FruitShopService {
    void process(List<FruitTransaction> parsed);
}

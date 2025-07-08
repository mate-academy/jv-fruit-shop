package core.basesyntax.service.shop;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}

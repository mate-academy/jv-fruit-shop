package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Report;
import java.util.List;

public interface ShopService {
    Report process(List<FruitTransaction> transactions);
}

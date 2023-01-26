package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionOperationsCalculator {
    List<FruitTransaction> process(FruitDao dao);
}

package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public interface TransactionService {
    FruitDao dao = new FruitDao();

    void process(FruitTransaction transaction);
}

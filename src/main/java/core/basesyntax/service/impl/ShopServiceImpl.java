package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDao;
import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final FruitDao fruitDao;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        fruitDao = new FruitDaoImpl();
    }

    public FruitDao getFruitDao() {
        return fruitDao;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy
                    .choseOperationHandler(transaction.getOperation())
                    .executeOperation(fruitDao, transaction);
        }
    }
}

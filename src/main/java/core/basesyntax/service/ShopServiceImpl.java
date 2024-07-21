package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.domain.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final FruitDao fruitDao;

    public ShopServiceImpl(OperationStrategy operationStrategy, FruitDao fruitDao) {
        this.operationStrategy = operationStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        int appleQuantity = 0;
        int bananaQuantity = 0;
        for (FruitTransaction currentFruitTransaction : fruitTransactions) {
            FruitTransaction.Operation currentOperation = currentFruitTransaction.getOperation();
            int currentQuantity = currentFruitTransaction.getQuantity();
            if (currentFruitTransaction.getName() == FruitTransaction.FruitName.APPLE) {
                appleQuantity = operationStrategy.get(currentOperation)
                        .getQuantity(appleQuantity, currentQuantity);
            } else if (currentFruitTransaction.getName() == FruitTransaction.FruitName.BANANA) {
                bananaQuantity = operationStrategy.get(currentOperation)
                        .getQuantity(bananaQuantity, currentQuantity);
            }
        }
        fruitDao.add(new FruitTransaction(FruitTransaction.FruitName.APPLE, appleQuantity));
        fruitDao.add(new FruitTransaction(FruitTransaction.FruitName.BANANA, bananaQuantity));
    }
}

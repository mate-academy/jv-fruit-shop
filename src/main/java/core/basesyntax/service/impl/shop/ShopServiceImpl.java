package core.basesyntax.service.impl.shop;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.transaction.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import java.math.BigDecimal;
import java.util.List;

public class ShopServiceImpl implements ShopService {

    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        if (operationStrategy == null) {
            throw new IllegalArgumentException("Operation strategy can't be null");
        }
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions, FruitDao fruitDao) {
        if (transactions == null) {
            throw new IllegalArgumentException("Transactions can't be null");
        }
        if (fruitDao == null) {
            throw new IllegalArgumentException("FruitDao can't be null");
        }
        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                continue;
            }
            String fruit = transaction.getFruit();
            String storedQuantityStr = fruitDao.getQuantity(fruit);
            BigDecimal storedQuantity;
            if (storedQuantityStr == null) {
                storedQuantity = BigDecimal.ZERO;
            } else {
                try {
                    storedQuantity = new BigDecimal(storedQuantityStr);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid quantity: " + storedQuantityStr, e);
                }
            }

            OperationHandler handler = operationStrategy.getOperationHandler(
                    transaction.getOperation());
            try {
                String newQuantity = handler.apply(
                        storedQuantity,
                        BigDecimal.valueOf(transaction.getQuantity())
                );
                fruitDao.update(fruit, newQuantity);
            } catch (RuntimeException e) {
                throw new RuntimeException(
                        "Failed to process transaction: operation=" + transaction.getOperation()
                                + ", fruit=" + transaction.getFruit()
                                + ", quantity=" + transaction.getQuantity()
                                + ", storedQuantity=" + storedQuantity
                                + ", handler=" + handler.getClass().getSimpleName(),
                        e
                );
            }
        }
    }
}

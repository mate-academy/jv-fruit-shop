package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(FruitDao fruitDao, OperationStrategy strategy) {
        this.fruitDao = fruitDao;
        operationStrategy = strategy;
    }

    @Override
    public void createNewFruitTransaction(String type, String fruit, int quantity) {
        FruitTransaction.Operation operation = operationStrategy.get(type).getOperation();
        FruitTransaction fruitTransaction = new FruitTransaction(operation, fruit, quantity);
        fruitDao.add(fruitTransaction);
    }

    @Override
    public int getFruitCount(String fruit) {
        List<FruitTransaction> fruitTransactions = fruitDao.getFruitTransactionsByFruit(fruit);
        int count = 0;
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            count = operationStrategy.get(fruitTransaction.getOperation().getCode())
                    .getOperationResult(count, fruitTransaction.getQuantity());
        }
        return count;
    }
}

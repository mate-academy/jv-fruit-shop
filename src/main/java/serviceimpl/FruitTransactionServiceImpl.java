package serviceimpl;

import java.util.List;
import model.FruitTransaction;
import service.FruitTransactionService;
import service.OperationStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processFruitTransactions(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction transaction : fruitTransactionList) {
            operationStrategy.findRightStrategy(transaction.getOperation())
                    .doOperation(transaction);
        }
    }
}

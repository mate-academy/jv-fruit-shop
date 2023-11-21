package impl;

import impl.operation.OperationStrategy;
import java.util.List;
import model.FruitTransaction;
import service.ParseFruitTransactionService;

public class ParseFruitTransactionsImpl implements ParseFruitTransactionService {
    private final OperationStrategy operationStrategy;

    public ParseFruitTransactionsImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void parseFruitTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.getOperationHandler(fruitTransaction.getOperation())
                    .updateQuantity(fruitTransaction);
        }
    }
}

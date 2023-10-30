package serviceimpl;

import java.util.List;
import model.FruitTransaction;
import service.OperationStrategy;
import service.ReportMaking;

public class ReportMakingImpl implements ReportMaking {
    private final OperationStrategy operationStrategy;

    public ReportMakingImpl(OperationStrategy operationStrategy) {
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

package core.basesyntax.strategy;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.data.FruitTransaction.Operation;
import core.basesyntax.data.Stock;
import java.util.List;
import java.util.Map;

public class TransactionProcessorImpl implements TransactionProcessor {
    private static final String EXCEPTION_NO_SUCH_OPERATION_MESSAGE
            = "No such type operation";

    private DataHandler getOperationHandler(Operation operation) {
        switch (operation) {
            case BALANCE -> {
                return new BalanceDataHandler();
            }
            case SUPPLY -> {
                return new SupplyDataHandler();
            }
            case PURCHASE -> {
                return new PurchaseDataHandler();
            }
            case RETURN -> {
                return new ReturnDataHandler();
            }
            default -> throw new RuntimeException(EXCEPTION_NO_SUCH_OPERATION_MESSAGE);
        }
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionsList) {
        Stock report = new Stock();
        Map<String, Integer> data = report.getData();
        for (FruitTransaction transaction : fruitTransactionsList) {
            DataHandler handler = getOperationHandler(transaction.getOperation());
            handler.processWithData(transaction, data);
        }
    }
}

package core.basesyntax.strategy;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.data.FruitTransaction.Operation;
import core.basesyntax.data.Stock;
import java.util.List;
import java.util.Map;

public class OperationProcessor {
    private static final String EXCEPTION_NO_SUCH_OPERATION_MESSAGE
            = "No such type operation";

    private OperationHandler getOperationHandler(Operation operation) {

        switch (operation) {
            case BALANCE -> {
                return new BalanceOperationHandler();
            }
            case SUPPLY -> {
                return new SupplyOperationHandler();
            }
            case PURCHASE -> {
                return new PurchaseOperationHandler();
            }
            case RETURN -> {
                return new ReturnOperationHandler();
            }
            default -> throw new RuntimeException(EXCEPTION_NO_SUCH_OPERATION_MESSAGE);
        }
    }

    public Stock process(List<FruitTransaction> fruitTransactionsList) {
        Stock report = new Stock();
        Map<String, Integer> data = report.getData();
        for (FruitTransaction transaction : fruitTransactionsList) {
            OperationHandler handler = getOperationHandler(transaction.getOperation());
            handler.processWithData(transaction, data);
        }
        return report;
    }
}

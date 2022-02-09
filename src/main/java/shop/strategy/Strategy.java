package shop.strategy;

import java.util.List;
import java.util.Map;
import shop.impl.FruitTransaction;

public class Strategy {
    private final Map<String, OperationHandler> handlers;

    public Strategy(Map<String, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public void performOperation(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler handler = handlers.get(fruitTransaction.getOperation());
            handler.apply(fruitTransaction);
        }
    }
}

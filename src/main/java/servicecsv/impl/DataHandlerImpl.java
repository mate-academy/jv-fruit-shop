package servicecsv.impl;

import java.util.List;
import java.util.function.Consumer;
import model.FruitTransaction;
import servicecsv.DataHandler;
import strategy.OperationStrategy;

public class DataHandlerImpl implements DataHandler {
    private OperationStrategy operationStrategy;

    public DataHandlerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void handleData(List<FruitTransaction> fruitTransactionList) {
        Consumer<FruitTransaction> consumer = fruitTransaction ->
                operationStrategy
                        .get(fruitTransaction.getOperation())
                        .handleOperation(fruitTransaction.getFruit(),
                                fruitTransaction.getQuantity());
        fruitTransactionList.forEach(consumer);

    }
}

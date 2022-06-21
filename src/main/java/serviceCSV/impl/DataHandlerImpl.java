package serviceCSV.impl;

import Strategy.OperationStrategy;
import model.FruitTransaction;
import serviceCSV.DataHandler;

import java.util.List;
import java.util.function.Consumer;

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
                        .handleOperation(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        fruitTransactionList.forEach(consumer);

    }
}

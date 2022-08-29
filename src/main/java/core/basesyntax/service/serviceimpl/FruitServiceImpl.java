package core.basesyntax.service.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.strategyimpl.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public FruitServiceImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(fruitTransaction
                -> operationHandlerMap.get(fruitTransaction.getOperation())
                .processedTransaction(fruitTransaction));
    }

    @Override
    public String createReport(List<FruitTransaction> fruitTransactions) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruits,quantity");
        Storage.FRUITS.values().forEach(fruitData
                -> stringBuilder.append(System.lineSeparator())
                .append(fruitData.getFruitName())
                .append(",")
                .append(fruitData.getQuantity()));
        return stringBuilder.toString();
    }

}

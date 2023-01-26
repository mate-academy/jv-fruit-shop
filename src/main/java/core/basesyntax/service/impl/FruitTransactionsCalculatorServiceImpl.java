package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionsCalculatorService;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class FruitTransactionsCalculatorServiceImpl implements FruitTransactionsCalculatorService {
    private static Map<String, Integer> calculatedDataForReport = new HashMap<>();
    private FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
    private OperationHandler handler;

    @Override
    public Map<String, Integer> calculateMap(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        if (operationHandlerMap == null || operationHandlerMap.isEmpty()) {
            throw new RuntimeException("Please provide valid operations map");
        }
        for (FruitTransaction fruitTransaction : Storage.transactions) {
            int currentFruitAmount = calculatedDataForReport
                    .getOrDefault(fruitTransaction.getFruit(), 0);
            int operationAmount = fruitTransaction.getQuantity();
            handler = operationHandlerMap.get(fruitTransaction.getOperation());
            int updatedAmount = handler.getUpdatedAmount(currentFruitAmount,operationAmount);
            if (updatedAmount < 0) {
                throw new RuntimeException("Fruit leftovers can't be negative");
            }
            calculatedDataForReport.put(fruitTransaction.getFruit(), updatedAmount);
        }
        return calculatedDataForReport;
    }
}

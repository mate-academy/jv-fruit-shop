package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.Operations;
import java.util.ArrayList;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final String HEADER_LINE = "fruit,quantity";
    private static final String COMMA = ",";
    FruitStorage fruitStorage = new FruitStorage();

    public FruitServiceImpl() {
    }

    public FruitStorage getFruitStorage() {
        return fruitStorage;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            if (Operations.valueOf(transaction.getOperation().toString()) != null) {
                Operations operation = Operations.valueOf(transaction.getOperation()
                        .toString().toUpperCase());
                OperationHandler handler = operation.getHandler();
                handler.handleOperation(transaction);
            }
        }
    }

    @Override
    public List<String> generateReport() {
        List<String> reportLines = new ArrayList<>();
        reportLines.add(HEADER_LINE);
        for (FruitTransaction fruit : fruitStorage.getAllFruits()) {
            reportLines.add(fruit.getName() + COMMA + fruit.getQuantity());
        }
        return reportLines;
    }
}

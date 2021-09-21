package core.basesyntax.service.report;

import core.basesyntax.model.FruitType;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.service.parser.OperationParser;
import java.util.HashMap;
import java.util.Map;

public class FruitAmountCounterImpl implements FruitAmountCounter {
    private OperationStrategy operationStrategy;
    private OperationParser operationParser;

    public FruitAmountCounterImpl(OperationStrategy operationStrategy,
                                  OperationParser operationParser) {
        this.operationStrategy = operationStrategy;
        this.operationParser = operationParser;
    }

    @Override
    public Map<FruitType, Integer> countFruitByOperation() {
        Map<FruitType, Integer> totalFruitAmount = new HashMap<>();
        for (TransactionDto data : operationParser.parseOperations()) {
            operationStrategy.getOperationHandler(data.getOperationType())
                    .setDataInStorage(totalFruitAmount, data.getFruitType(), data.getFruitAmount());
        }
        return totalFruitAmount;
    }
}

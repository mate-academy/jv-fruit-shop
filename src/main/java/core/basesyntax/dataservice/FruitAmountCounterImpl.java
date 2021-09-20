package core.basesyntax.dataservice;

import core.basesyntax.model.FruitType;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.operation.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class FruitAmountCounterImpl implements FruitAmountCounter {
    private OperationStrategy operationStrategy;
    private OperationParser operationParser;

    public FruitAmountCounterImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.operationParser = new OperationParserImpl();
    }

    @Override
    public Map<FruitType, Integer> countFruitByOperation(String filePathFrom) {
        Map<FruitType, Integer> totalFruitAmount = new HashMap<>();
        for (TransactionDto data : operationParser.parseOperations(filePathFrom)) {
            operationStrategy.getOperationHandler(data.getOperationType())
                    .setDataInStorage(totalFruitAmount, data.getFruitType(), data.getFruitAmount());
        }
        return totalFruitAmount;
    }
}

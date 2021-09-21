package core.basesyntax.service.report;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.operation.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<Fruit, Integer> countFruitByOperation(List<TransactionDto> operations) {
        Map<Fruit, Integer> totalFruitAmount = new HashMap<>();
        for (TransactionDto operation : operations) {
            operationStrategy.getOperationHandler(operation.getOperationType())
                    .setDataInStorage(totalFruitAmount,
                            operation.getFruitType(),
                            operation.getFruitAmount());
        }
        return totalFruitAmount;
    }
}

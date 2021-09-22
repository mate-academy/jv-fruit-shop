package core.basesyntax.service.report;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.operation.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void saveFruitByOperation(List<TransactionDto> operations) {
        for (TransactionDto operation : operations) {
            FruitStorage.fruitsDataBase.put(operation.getFruitType(), 0);
        }
        for (TransactionDto operation : operations) {
            FruitStorage.fruitsDataBase.put(operation.getFruitType(),
                    operationStrategy.getOperationHandler(operation.getOperationType())
                    .newAmountByOperation(FruitStorage.fruitsDataBase.get(operation.getFruitType()),
                            operation.getFruitAmount()));
        }
    }
}

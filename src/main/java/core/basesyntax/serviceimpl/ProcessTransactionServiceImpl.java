package core.basesyntax.serviceimpl;

import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ProcessTransactionService;
import java.util.List;

public class ProcessTransactionServiceImpl implements ProcessTransactionService {
    private final FruitStrategy fruitStrategy;

    public ProcessTransactionServiceImpl(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void processData(List<FruitTransaction> data) {
        for (FruitTransaction entry : data) {
            OperationHandler service = fruitStrategy.getOperationService(entry.getOperation());
            service.handler(entry);
        }
    }
}

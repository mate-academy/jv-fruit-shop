package core.basesyntax.serviceimpl;

import core.basesyntax.service.OperationService;
import core.basesyntax.service.TransactionService;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final FruitStrategy fruitStrategy;

    public TransactionServiceImpl(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void processData(List<FruitTransaction> data) {
        for (FruitTransaction entry : data) {
            OperationService service = fruitStrategy.getOperationService(entry.getOperation());
            service.handle(entry);
        }
    }
}

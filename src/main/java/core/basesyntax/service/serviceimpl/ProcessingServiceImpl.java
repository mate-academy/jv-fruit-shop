package core.basesyntax.service.serviceimpl;

import core.basesyntax.model.ItemOperation;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ProcessingService;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class ProcessingServiceImpl implements ProcessingService {
    private final OperationStrategy activitiesStrategy;

    public ProcessingServiceImpl(Map<Operation, OperationHandler> map) {
        this.activitiesStrategy = new OperationStrategyImpl(map);
    }

    public void processTransaction(List<ItemOperation> transactions) {
        transactions
                .forEach(transaction ->
                        activitiesStrategy.get(transaction.getOperation()).update(transaction));
    }
}

package core.basesyntax.strategy;

import core.basesyntax.model.TransactionDto;
import java.util.Map;

public class Strategy {
    private final Map<String, OperationHandler> mapForStrategy;

    public Strategy(Map<String, OperationHandler> mapForStrategy) {
        this.mapForStrategy = mapForStrategy;
    }

    public OperationHandler getHandler(TransactionDto transactionDto) {
        return mapForStrategy.get(transactionDto.getOperation());
    }
}

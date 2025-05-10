package core.basesyntax.strategy;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;

public class TransationProcessorImpl implements TransationProcessor {

    private OperationStategy operationStategy;

    public TransationProcessorImpl(OperationStategy operationStategy) {
        this.operationStategy = operationStategy;
    }

    public void process(List<FruitTransactionDto> transactions) {
        for (var transaction : transactions) {
            OperationHandler handler = operationStategy.get(transaction);
            handler.apply(transaction);
        }
    }
}

package core.basesyntax.service;

import core.basesyntax.model.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.operations.OperationHendler;
import core.basesyntax.service.strategy.OperationsStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateImpl implements Calculate {
    private static final Map<String, Integer> FRUIT_COUNT = Storage.FRUIT_COUNT;
    private static final String DATA_SEPARATOR = ",";
    private final OperationsStrategy operationsStrategy;

    public CalculateImpl(OperationsStrategy operationsStrategy) {
        this.operationsStrategy = operationsStrategy;
    }

    @Override
    public List<String> calculate(List<TransactionDto> parsedInfo) {
        for (TransactionDto transactionDto : parsedInfo) {
            OperationHendler operation = operationsStrategy.get(transactionDto.getOperation());
            operation.apply(transactionDto);
        }
        return FRUIT_COUNT.entrySet().stream()
                .map(v -> v.getKey() + DATA_SEPARATOR + v.getValue())
                .collect(Collectors.toList());
    }
}

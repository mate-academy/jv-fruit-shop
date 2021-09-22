package core.basesyntax.service;

import core.basesyntax.model.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.operations.OperationHendler;
import core.basesyntax.service.strategy.OperationsStrategy;
import java.util.List;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String DATA_SEPARATOR = ",";
    private final OperationsStrategy operationsStrategy;

    public ReportCreatorImpl(OperationsStrategy operationsStrategy) {
        this.operationsStrategy = operationsStrategy;
    }

    @Override
    public List<String> createReport(List<TransactionDto> parsedInfo) {
        for (TransactionDto transactionDto : parsedInfo) {
            OperationHendler operation = operationsStrategy.get(transactionDto.getOperation());
            operation.apply(transactionDto);
        }
        return Storage.FRUIT_COUNT.entrySet().stream()
                .map(v -> v.getKey() + DATA_SEPARATOR + v.getValue())
                .collect(Collectors.toList());
    }
}

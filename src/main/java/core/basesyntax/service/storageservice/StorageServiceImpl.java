package core.basesyntax.service.storageservice;

import core.basesyntax.model.dto.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private final OperationStrategy operationStrategy;

    public StorageServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void addToStorage(List<TransactionDto> transactionDtos) {
        for (TransactionDto entity : transactionDtos) {
            operationStrategy.getHandler(entity.getOperation())
                    .apply(entity.getFruit(), entity.getAmount());
        }
    }
}

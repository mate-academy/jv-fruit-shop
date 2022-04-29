package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void updateStorageInfo(List<TransactionDto> transactionDtos) {
        for (TransactionDto transaction : transactionDtos) {
            operationStrategy.get(transaction.getOperation())
                            .apply(transaction);
        }
    }
}

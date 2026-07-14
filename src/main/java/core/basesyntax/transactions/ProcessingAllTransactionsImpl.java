package core.basesyntax.transactions;

import core.basesyntax.activities.OperationHandler;
import core.basesyntax.maps.StorageForChoosingTypeOperation;
import java.util.List;

public class ProcessingAllTransactionsImpl implements ProcessingAllTransactions {
    private final StorageForChoosingTypeOperation operationStorage;

    public ProcessingAllTransactionsImpl(StorageForChoosingTypeOperation operationStorage) {
        this.operationStorage = operationStorage;
    }

    @Override
    public void processAllTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler =
                    operationStorage.getHandler(transaction.getOperation());

            if (handler == null) {
                throw new RuntimeException("Handler not found for operation: "
                                + transaction.getOperation());
            }
            handler.operationHandler(transaction);
        }
    }
}

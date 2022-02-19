package core.basesyntax.strategy;

import core.basesyntax.service.StorageService;
import core.basesyntax.service.TransactionLog;

public interface TransDistrStrategy {
    StorageService choseStorageService(TransactionLog transactionLog);
}

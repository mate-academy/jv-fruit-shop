package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.LogIteratorService;
import core.basesyntax.service.TransactionLog;
import core.basesyntax.strategy.TransDistrStrategy;
import java.util.List;

public class LogIteratorServiceImpl implements LogIteratorService {
    @Override
    public void iterate(List<TransactionLog> transLogs,
                        TransDistrStrategy transDistrStrategy,
                        Storage storage) {
        for (TransactionLog operation : transLogs) {
            transDistrStrategy.choseStorageService(operation)
                    .actionToStorage(operation, storage);
        }
    }
}

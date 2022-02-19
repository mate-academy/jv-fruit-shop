package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.TransDistrStrategy;
import java.util.List;

public interface LogIteratorService {
    void iterate(List<TransactionLog> transLogs,
                 TransDistrStrategy transDistrStrategy,
                 Storage storage);
}

package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
import java.util.List;

public interface DataProcessingService {
    void processData(List<Transaction> activities);
}

package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface ProcessDataService {
    void processData(List<Transaction> list);
}

package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.DataProcessingService;
import java.util.List;

public class DataProcessingServiceImpl implements DataProcessingService {
    @Override
    public void processData(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            transaction.getStrategy().makeOperation(transaction);
        }
    }
}

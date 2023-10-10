package core.basesyntax.services;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface ProccessingDataService {
    void process(List<Transaction> data);
}

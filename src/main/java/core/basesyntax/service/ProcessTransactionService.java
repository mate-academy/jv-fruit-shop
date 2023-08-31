package core.basesyntax.service;

import core.basesyntax.serviceimpl.FruitTransaction;
import java.util.List;

public interface ProcessTransactionService {
    void processData(List<FruitTransaction> data);

}

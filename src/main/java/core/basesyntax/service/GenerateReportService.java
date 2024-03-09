package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface GenerateReportService {
    void updateFruitQuantities(List<FruitTransaction> fruitTransactions);
}

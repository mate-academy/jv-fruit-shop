package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitService {
    String generateReport(List<FruitTransaction> transactions);
}

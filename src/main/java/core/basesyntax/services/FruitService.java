package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitService {
    List<FruitTransaction> getTransaction(List<String> transaction);

    String createReport();
}

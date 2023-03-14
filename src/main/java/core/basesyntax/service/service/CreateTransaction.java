package core.basesyntax.service.service;

import core.basesyntax.service.model.FruitTransaction;
import java.util.List;

public interface CreateTransaction {
    List<FruitTransaction> create(List<String[]> list);
}

package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseTransaction {
    List<FruitTransaction> processing(List<String> list);
}

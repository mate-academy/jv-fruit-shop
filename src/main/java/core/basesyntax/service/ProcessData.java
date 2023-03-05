package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessData {
    List<FruitTransaction> create(List<String> list);
}

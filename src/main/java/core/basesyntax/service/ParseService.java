package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseService {
    List<FruitTransaction> parseTransaction(List<String> dataFromFile);
}

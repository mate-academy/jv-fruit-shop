package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StorageService {
    List<FruitTransaction> fillActivityStorage(List<FruitTransaction> list);
}

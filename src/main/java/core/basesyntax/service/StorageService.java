package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;

public interface StorageService {
    void fillActivityStorage(ArrayList<FruitTransaction> list);
}

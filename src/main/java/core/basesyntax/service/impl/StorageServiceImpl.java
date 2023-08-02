package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;
import java.util.ArrayList;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    @Override
    public List<FruitTransaction> fillActivityStorage(List<FruitTransaction> list) {
        if (list == null) {
            throw new RuntimeException("");
        }

        return new ArrayList<>(list);
    }

}

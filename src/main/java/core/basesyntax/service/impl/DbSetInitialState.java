package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DbInitialize;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DbSetInitialState implements DbInitialize {
    @Override
    public Storage initialStorage(List<Operation> initialData) {
        Set<String> keySet = initialData.stream()
                .map(Operation::getFruitName)
                .collect(Collectors.toSet());
        return Storage.ofKeys(keySet);
    }
}

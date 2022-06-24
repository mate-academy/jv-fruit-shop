package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import java.util.List;

public interface DbInitialize {
    Storage initialStorage(List<Operation> initialData);

}

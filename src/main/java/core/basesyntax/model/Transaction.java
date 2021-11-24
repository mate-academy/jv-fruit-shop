package core.basesyntax.model;

import core.basesyntax.db.Storage;

public interface Transaction {
    Integer apply(Storage storage);
}

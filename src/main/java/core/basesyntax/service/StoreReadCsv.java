package core.basesyntax.service;

import core.basesyntax.model.Store;

public interface StoreReadCsv {
    Store read(String fileName);
}

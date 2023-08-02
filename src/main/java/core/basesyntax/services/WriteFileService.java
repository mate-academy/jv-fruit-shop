package core.basesyntax.services;

import core.basesyntax.db.Storage;

public interface WriteFileService {
    boolean writeToFile(Storage fruitDB, String fileName);
}

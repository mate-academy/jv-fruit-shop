package core.basesyntax.service;

import java.io.File;

public interface StorageWriteService {
    void writeFromDb(String report, File toFile);
}

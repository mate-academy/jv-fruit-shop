package core.basesyntax.fileservice;

import core.basesyntax.storage.Storage;

public interface FileWrite {
    void writeToFile(String[] fileInfo, Storage storage);
}

package core.basesyntax.fileservice;

import core.basesyntax.storage.Storage;

public interface LocalFileWriter {
    void writeToFile(String[] fileInfo, Storage storage);
}

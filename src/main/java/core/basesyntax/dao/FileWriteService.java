package core.basesyntax.dao;

import java.io.File;

public interface FileWriteService {
    void writeToFile(String data, File toFile);
}

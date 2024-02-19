package core.basesyntax.dao;

import java.io.File;

public interface StorageDao {
    String addFile(String sourceFilePath);

    File writeReport(String path);
}

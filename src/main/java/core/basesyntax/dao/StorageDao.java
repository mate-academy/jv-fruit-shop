package core.basesyntax.dao;

import core.basesyntax.db.Storage;

import java.io.File;
import java.io.IOException;

public interface StorageDao {
    void addFile();

    File createReport();
}

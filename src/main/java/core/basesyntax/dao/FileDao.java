package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.List;

public interface FileDao {
    public void addToStorage(List<String> readFile, Storage storage);
}

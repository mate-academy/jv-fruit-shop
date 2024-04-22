package core.basesyntax.dao;

import java.util.List;

public interface StorageDao {
    List<String> get(String filePath);
}

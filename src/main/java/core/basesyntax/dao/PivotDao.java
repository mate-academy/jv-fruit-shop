package core.basesyntax.dao;

import java.util.List;

public interface PivotDao {
    void writePivotFile(String fileName, List<String> stringList);
}

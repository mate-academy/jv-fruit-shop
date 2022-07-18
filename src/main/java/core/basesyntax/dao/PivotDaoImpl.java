package core.basesyntax.dao;

import java.util.List;

public class PivotDaoImpl implements PivotDao {
    @Override
    public void writePivotFile(String fileName, List<String> stringList) {
        new PivotDaoCsvImpl().writePivotFile(fileName, stringList);
    }
}

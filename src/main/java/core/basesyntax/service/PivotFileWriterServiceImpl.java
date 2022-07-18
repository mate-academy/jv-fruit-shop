package core.basesyntax.service;

import core.basesyntax.dao.PivotDao;
import core.basesyntax.dao.PivotDaoCsvImpl;
import java.util.List;

public class PivotFileWriterServiceImpl implements PivotFileWriterService {
    private static final String PIVOT_FILE_NAME = "src/main/resources/pivot.csv";
    private final PivotDao pivotDao = new PivotDaoCsvImpl();

    @Override
    public void exportPivotToFile(List<String> report) {
        pivotDao.writePivotFile(PIVOT_FILE_NAME, report);
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportService;

public class FileReportService implements ReportService<Object> {
    private FruitDaoImpl fruitDao;

    public FileReportService(FruitDaoImpl fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public boolean createReport(Object reportOperation) {
        return true;
    }
}

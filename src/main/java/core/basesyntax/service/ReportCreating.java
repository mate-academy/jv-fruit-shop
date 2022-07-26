package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;

public interface ReportCreating {
    void createReport(FruitsDao fruitsDao, String columnsNamesLine);
}

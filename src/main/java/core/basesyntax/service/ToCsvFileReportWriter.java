package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import java.io.File;

public interface ToCsvFileReportWriter {
    void writeReport(File report, FruitsDao fruitsDao, String columnsNamesLine);
}

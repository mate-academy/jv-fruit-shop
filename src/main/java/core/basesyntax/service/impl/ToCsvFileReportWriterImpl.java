package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.service.ToCsvFileReportWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class ToCsvFileReportWriterImpl implements ToCsvFileReportWriter {

    @Override
    public void writeReport(File report, FruitsDao fruitsDao, String columnsNamesLine) {
        try {
            Files.write(report.toPath(), columnsNamesLine.getBytes());
            for (String fruit: fruitsDao.getFruitsNames()) {
                Files.write(report.toPath(), (System.lineSeparator() + fruit + ","
                        + fruitsDao.getAmount(fruit)).getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file " + report.getName(), e);
        }
    }
}

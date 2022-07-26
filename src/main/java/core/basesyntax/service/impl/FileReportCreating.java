package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.service.ReportCreating;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileReportCreating implements ReportCreating {
    @Override
    public void createReport(FruitsDao fruitsDao, String columnsNamesLine) {
        String[] fruits = fruitsDao.getFruitsNames();
        File report = new File("src/main/resources/report.csv");
        try {
            Files.write(report.toPath(), columnsNamesLine.getBytes());
            for (String fruit: fruits) {
                Files.write(report.toPath(), (System.lineSeparator() + fruit + "," +
                        fruitsDao.getAmount(fruit)).getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't generate report", e);
        }
    }
}

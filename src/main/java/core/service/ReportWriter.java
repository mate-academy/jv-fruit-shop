package core.service;

import core.service.impl.Writable;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriter implements Writable {
    private static final String FIRST_LINE = "fruit,quantity" + System.lineSeparator();
    private static final String PATH_DEFAULT = "src/main/java/core/db/dailyReport/";

    @Override
    public void createReport(String filePath, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_DEFAULT + filePath))) {
            writer.write(FIRST_LINE + report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data in file " + filePath, e);
        }
    }
}

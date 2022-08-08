package core.basesyntax.service.fileoperation.impl;

import core.basesyntax.service.fileoperation.CreateReport;
import core.basesyntax.service.fileoperation.CsvFileWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterImpl implements CsvFileWriter {
    private final CreateReport report = new CreateReportImpl();

    @Override
    public void writeFile(String filePath) {
        File csvOutputFile = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(csvOutputFile)) {
            fileWriter.write(report.getReport());
        } catch (IOException e) {
            throw new RuntimeException("Can't create write fileoperation" + filePath, e);
        }
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReportToFile implements ReportWriter {
    @Override
    public void write(String fileReportPath, String report) {
        File file = new File(fileReportPath);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file!");
        }
    }
}

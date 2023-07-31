package core.basesyntax.service.impl;

import core.basesyntax.service.ReportData;
import core.basesyntax.service.WriteService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class WriteServiceImpl implements WriteService {
    private ReportData reportData = new ReportDataImpl();

    @Override
    public void writeToFile(Path path) {
        String[] report = reportData.generateReport().split(System.lineSeparator());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            for (String data : report) {
                writer.write(data);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + path.toFile(), e);
        }
    }
}

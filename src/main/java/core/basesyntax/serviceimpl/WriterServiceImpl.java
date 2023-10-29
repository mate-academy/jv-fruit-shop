package core.basesyntax.serviceimpl;

import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeAll(String pathToFile) {
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(pathToFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while writing to file" + pathToFile, e);
        }
    }
}

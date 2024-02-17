package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriterService;
import core.basesyntax.service.StringReportService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DataWriterServiceImpl implements DataWriterService {
    private final StringReportService stringReportService;

    public DataWriterServiceImpl(StringReportService reportService) {
        this.stringReportService = reportService;
    }

    @Override
    public void writeReportToFile(Map<String, Integer> report, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            String reportString = stringReportService.generateReportString(report);
            writer.write(reportString);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file " + fileName, e);
        }
    }
}

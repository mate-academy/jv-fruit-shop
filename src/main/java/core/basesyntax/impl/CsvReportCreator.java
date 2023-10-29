package core.basesyntax.impl;

import core.basesyntax.report.ReportCreator;
import core.basesyntax.report.ReportService;
import core.basesyntax.report.WriterService;
import java.io.IOException;
import java.util.Map;

public class CsvReportCreator implements ReportService, ReportCreator {
    private final WriterService writerService;
    private final String outputPath;

    public CsvReportCreator(WriterService writerService, String outputPath) {
        this.writerService = writerService;
        this.outputPath = outputPath;
    }

    @Override
    public String generateReport(Map<String, Integer> fruitInventory) {
        StringBuilder report = new StringBuilder("Fruit,Quantity\n");
        for (Map.Entry<String, Integer> entry : fruitInventory.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }

    @Override
    public void createReport(Map<String, Integer> fruitInventory) throws IOException {
        String report = generateReport(fruitInventory);
        writerService.writeToFile(report, outputPath);
    }

    @Override
    public void createReport(Map<String, Integer> fruitInventory,
                             String filePath) throws IOException {
    }
}

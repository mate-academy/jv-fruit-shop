package core.basesyntax;

import java.util.Map;

public class CsvReportCreator implements ReportCreator{
    private final FileWriter fileWriter;

    public CsvReportCreator(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void createReport(FruitStore fruitStore, String filePath) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : fruitStore.getFruitInventory().entrySet()) {
            report.append(System.lineSeparator());
            report.append(entry.getKey()).append(",").append(entry.getValue());
        }
        fileWriter.writeToFile(report.toString(), filePath);
    }

}

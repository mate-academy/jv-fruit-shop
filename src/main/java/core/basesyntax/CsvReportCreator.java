package core.basesyntax;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvReportCreator implements ReportCreator {
    private String filePath;

    public CsvReportCreator(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void createReport(Map<String, Integer> fruitInventory, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("fruit,quantity\n");

            for (Map.Entry<String, Integer> entry : fruitInventory.entrySet()) {
                String fruit = entry.getKey();
                int quantity = entry.getValue();

                String line = String.format("%s,%d\n", fruit, quantity);
                writer.write(line);

            }

            System.out.println("Report created successfully" + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error creating report", e);
        }
    }
}

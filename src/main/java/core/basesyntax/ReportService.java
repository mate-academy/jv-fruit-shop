package core.basesyntax;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportService {
    public static void generateReport(Map<String, Integer> fruitStock, String reportFilePath)
            throws IOException {
        FileWriter writer = new FileWriter(reportFilePath);
        writer.write("fruit,quantity\n");

        for (Map.Entry<String, Integer> entry : fruitStock.entrySet()) {
            writer.write(entry.getKey() + "," + entry.getValue() + "\n");
        }

        writer.close();
    }
}

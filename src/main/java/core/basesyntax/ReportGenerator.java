package core.basesyntax;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGenerator {
    public static void generateReport(List<FruitTransaction> transactions, String reportFilePath) {
        List<String> reportLines = transactions.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit,
                        Collectors.summingInt(FruitTransaction::getQuantity)))
                .entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());

        try (FileWriter writer = new FileWriter(reportFilePath)) {
            // Write the report to a new CSV file
            writer.write("fruit,quantity\n");
            for (String line : reportLines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing report to file", e);
        }
    }
}

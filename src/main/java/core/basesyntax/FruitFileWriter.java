package core.basesyntax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FruitFileWriter {
    public static void fileCompile(List<Fruit> report) throws IOException {
        File file = new File("Report");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file))) {
            bufferedWriter.write("fruit" + "," + "quantity");
            bufferedWriter.newLine();
            Map<String, Long> result = AvailableFruit.getStockReport(report);
            for (Map.Entry<String, Long> entry : result.entrySet()) {
                bufferedWriter.write(entry.getKey() + "," + entry.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("File can't be created", e);
        }
    }
}

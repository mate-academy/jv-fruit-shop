package core.basesyntax.filesworking;

import core.basesyntax.daily.AvailableFruit;
import core.basesyntax.daily.Fruit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReportWriter {
    public static void fileCompile(List<Fruit> report) throws IOException {
        String outputFilePath = null;
        File file = new File("Report");
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new java.io.FileWriter(file));

            bufferedWriter.write("fruit" + "," + "quantity");
            bufferedWriter.newLine();
            Map<String, Integer> result = AvailableFruit.endStock(report);
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                bufferedWriter.write(entry.getKey() + "," + entry.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("File can't be created");
        } finally {
            try {
                bufferedWriter.close();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}

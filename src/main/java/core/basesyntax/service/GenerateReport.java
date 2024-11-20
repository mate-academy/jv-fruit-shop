package core.basesyntax.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GenerateReport {

    private String resultFileName;

    public GenerateReport(String resultFileName) {
        this.resultFileName = resultFileName;
    }

    public void generateReport(Map<String, Integer> fruitQuantity) {
        File report = new File(resultFileName);

        try {
            if (!report.exists()) {
                report.createNewFile();
            }

            try (FileWriter fileWriter = new FileWriter(report)) {
                fileWriter.write("fruit,quantity\n");

                for (Map.Entry<String, Integer> entry : fruitQuantity.entrySet()) {
                    String fruit = entry.getKey();
                    Integer quantity = entry.getValue();
                    fileWriter.write(fruit + "," + quantity + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException("Can't write in that file!", e);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't create that file!", e);
        }
    }
}

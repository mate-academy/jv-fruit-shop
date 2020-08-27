package core.basesyntax.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class CsvFileWriterService implements FileWriterService {

    @Override
    public void writeToFile(String filePath, Map<String, Integer> formattedData) {
        StringBuilder formattedLines = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : formattedData.entrySet()) {
            formattedLines.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue().toString())
                    .append("\n");
        }
        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            writer.write(formattedLines.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The output file can't be found.", e);
        }
    }
}

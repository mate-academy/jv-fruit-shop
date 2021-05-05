package core.basesyntax.fileservice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter implements Writer {
    private static final String CSV_HEADER = "fruit,quantity";

    @Override
    public void writeToFile(String fileName, List<String> data) {
        try (FileWriter writer = new FileWriter("report.csv", false)) {

            writer.write(CSV_HEADER);
            writer.append('\n');
            for (String word : data) {
                writer.append(word);
                writer.append("\n");
            }

            writer.flush();
        } catch (IOException ex) {
            throw new RuntimeException("Can`t write to file!");
        }
    }
}

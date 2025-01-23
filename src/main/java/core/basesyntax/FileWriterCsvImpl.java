package core.basesyntax;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterCsvImpl implements FileWriterCsv {
    @Override
    public void write(String source, String report) {
        try (FileWriter fileWriter = new FileWriter(source);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(report);

        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + source, e);
        }
    }
}

package core.basesyntax.service.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterWithResultsImpl implements FileWriterWithResults {
    private static final String FIRST_LINE = "fruit,quantity";

    @Override
    public void writeResultToFile(String filePath, List<String> outputInfo) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(FIRST_LINE + System.lineSeparator());
            for (String line : outputInfo) {
                bufferedWriter.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to this file, " + filePath, e);
        }
    }
}

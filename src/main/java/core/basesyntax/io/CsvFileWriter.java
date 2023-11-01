package core.basesyntax.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriter implements WriteToFile {
    private static final String EXCEPTION_WRITE_DATA_MESSAGE = "Can't write data to file";

    @Override
    public void writeFile(List<String> report, String filepath) {
        File file = new File(filepath);
        for (String line : report) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
                bufferedWriter.write(line);
            } catch (IOException e) {
                throw new RuntimeException(EXCEPTION_WRITE_DATA_MESSAGE, e);
            }
        }
    }
}

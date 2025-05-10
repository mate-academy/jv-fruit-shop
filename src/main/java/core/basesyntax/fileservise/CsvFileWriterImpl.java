package core.basesyntax.fileservise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriterImpl implements CsvFileWriter {
    @Override
    public void writeToFile(List<String> report, String toFileName) {
        File file = new File(toFileName);
        try {
            file.delete();
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can`t create new file", e);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName, true))) {
            for (String record : report) {
                bufferedWriter.write(record + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant write to file " + toFileName, e);
        }
    }
}

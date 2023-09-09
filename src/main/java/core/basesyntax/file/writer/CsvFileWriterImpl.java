package core.basesyntax.file.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriterImpl implements CsvFileWriter {
    @Override
    public void writeDataToFile(File file, List<String> report) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String s : report) {
                fileWriter.write(s);
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to file " + file.getPath(), e);
        }
    }
}

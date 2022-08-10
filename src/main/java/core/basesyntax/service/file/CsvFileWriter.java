package core.basesyntax.service.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class CsvFileWriter implements FileWriter {
    @Override
    public void writeFile(String path, String data) {
        File fileOut = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileOut))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't wright data to file " + fileOut, e);
        }
    }
}

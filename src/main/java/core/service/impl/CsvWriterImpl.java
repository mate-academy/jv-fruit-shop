package core.service.impl;

import core.service.Writer;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterImpl implements Writer {
    private static final String FILE_PATH = "src/main/resources/";
    
    @Override
    public void writeToFile(String data, String fileName) {
        try (FileWriter writer = new FileWriter(FILE_PATH + fileName)) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file " + fileName, e);
        }
    }
}

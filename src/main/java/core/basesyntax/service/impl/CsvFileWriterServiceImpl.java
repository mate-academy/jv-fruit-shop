package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String path, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to file: " + path, e);
        }
    }
}

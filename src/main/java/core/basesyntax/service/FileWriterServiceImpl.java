package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String report, String pathName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + pathName, e);
        }
    }
}

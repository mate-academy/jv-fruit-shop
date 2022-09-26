package core.basesyntax.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void writeToFile(File file, String text) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file ", e);
        }
    }
}

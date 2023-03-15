package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void writeToFile(String filename, List<String> data) {
        File file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + file, e);
        }

        for (String productInfo : data) {
            String dataToWrite = productInfo + System.lineSeparator();
            try {
                Files.write(file.toPath(), dataToWrite.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file " + file, e);
            }
        }
    }
}

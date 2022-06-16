package core.basesyntax.service.impl;

import core.basesyntax.service.FileWritingService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritingServiceImpl implements FileWritingService {
    @Override
    public File writeFile(String fileName, String data) {
        final File toFile = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
        return toFile;
    }
}

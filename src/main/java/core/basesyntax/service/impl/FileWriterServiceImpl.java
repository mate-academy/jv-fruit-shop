package core.basesyntax.service.impl;

import core.basesyntax.exception.FileNotFoundException;
import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String toFile, String infoToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(infoToWrite);
        } catch (IOException e) {
            throw new FileNotFoundException("Can't write to file:" + toFile);
        }
    }
}

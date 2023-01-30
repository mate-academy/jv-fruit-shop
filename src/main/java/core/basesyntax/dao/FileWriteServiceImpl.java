package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteServiceImpl implements FileWriterService {
    private static final String ERROR_MESSAGE = "Can`t write data to file ";

    @Override
    public void writeToFile(String data, String pathToFile) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(pathToFile))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE + pathToFile, e);
        }
    }
}

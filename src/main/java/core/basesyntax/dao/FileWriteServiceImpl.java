package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteServiceImpl implements FileWriteService {
    private static final String ERROR_MESSAGE = "Can`t write data to CSV file ";

    @Override
    public void writeToFile(String data, File toFile) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE + toFile, e);
        }
    }
}

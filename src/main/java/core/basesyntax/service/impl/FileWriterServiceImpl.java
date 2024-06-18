package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String FILE_NOT_WRITTEN_ERROR_MESSAGE = "Can't write data to the file: ";

    @Override
    public void write(String data, String toFileName, String path) {
        try (BufferedWriter bufferedReader = new BufferedWriter(
                new FileWriter(path + toFileName))) {
            bufferedReader.write(data);
        } catch (IOException e) {
            throw new RuntimeException(FILE_NOT_WRITTEN_ERROR_MESSAGE + toFileName, e);
        }
    }
}

package core.basesyntax.service.filesoperation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteImpl implements FileWrite {
    private static final String ERROR_WRITE_MESSAGE = "Can't write data to file ";

    @Override
    public void writer(String filePath, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException(ERROR_WRITE_MESSAGE + filePath, e);
        }
    }
}

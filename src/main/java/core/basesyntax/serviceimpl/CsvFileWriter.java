package core.basesyntax.serviceimpl;

import core.basesyntax.service.DataWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriter implements DataWriter {
    private static final String CANNOT_WRITE_TO_FILE_MESSAGE = "Cannot write to the file: ";

    @Override
    public boolean writeToFile(String[] report, String pathToFile) {
        File file = new File(pathToFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            for (String data : report) {
                bufferedWriter.write(data);
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(CANNOT_WRITE_TO_FILE_MESSAGE
                    + pathToFile, e);
        }
    }
}

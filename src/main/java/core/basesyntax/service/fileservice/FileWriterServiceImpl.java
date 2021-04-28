package core.basesyntax.service.fileservice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String FILE_PATH = "src\\main\\resources\\report.csv";

    @Override
    public void writeToFile(String data) {
        try (BufferedWriter fileWriter = new BufferedWriter(
                new FileWriter(FILE_PATH, true))) {
            fileWriter.append(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file!", e);
        }
    }
}

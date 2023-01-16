package core.basesyntax.service.implementations;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    private static final String FILE_PATH = "src/main/resources/report.csv";

    @Override
    public void writeToFile(String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + FILE_PATH, e);
        }
    }
}

package core.basesyntax.serviceimpl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class WriterServiceImpl implements WriterService {
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public void writeToFile(String filePath, Set<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(REPORT_HEADER);
            writer.newLine();
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file " + filePath, e);
        }
    }
}

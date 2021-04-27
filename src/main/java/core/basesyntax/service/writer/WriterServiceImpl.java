package core.basesyntax.service.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeReportToFile(String report, String outputDataFile) {
        Path path = Paths.get(outputDataFile);
        try {
            Files.write(path, report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + outputDataFile, e);
        }
    }
}

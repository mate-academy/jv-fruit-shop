package core.basesyntax.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReportWriterImpl implements ReportWriter {

    @Override
    public boolean writeReport(String report, String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.writeString(path, report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file in ReportWriter", e);
        }
        return true;
    }
}

package serviceimpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.ReportWriterService;

public class ReportWriterServiceImpl implements ReportWriterService {
    private static final String TO_FILE_PATH = "src/main/java/resources/report.csv";

    @Override
    public void write(String data) {
        try {
            Files.writeString(Path.of(TO_FILE_PATH), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + TO_FILE_PATH, e);
        }
    }
}

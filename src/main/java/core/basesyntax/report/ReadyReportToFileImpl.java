package core.basesyntax.report;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadyReportToFileImpl implements ReadyReportToFile {
    @Override
    public void readyReportToFile(String report, String filePath) {
        try {
            Files.writeString(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Can not write report to file: " + filePath, e);
        }
    }
}

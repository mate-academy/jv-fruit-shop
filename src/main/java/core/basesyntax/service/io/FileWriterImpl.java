package core.basesyntax.service.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String resultingReport, String reportFilePath) {
        File file = new File(reportFilePath);
        try {
            Files.write(file.toPath(), resultingReport.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("can't write data to file");
        }
    }
}

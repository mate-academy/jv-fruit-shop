package core.basesyntax.service.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultingReport, String outputFileName) {
        try {
            Files.write(Paths.get(outputFileName), resultingReport.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can not write the file: " + outputFileName);
        }
    }
}

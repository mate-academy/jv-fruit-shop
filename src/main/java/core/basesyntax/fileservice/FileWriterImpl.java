package core.basesyntax.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String report, String reportPath) {

        List<String> linesWithHeader = new ArrayList<>();
        linesWithHeader.add(report);

        try {
            Files.write(Path.of(reportPath), linesWithHeader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

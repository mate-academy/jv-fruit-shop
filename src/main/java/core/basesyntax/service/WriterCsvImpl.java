package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class WriterCsvImpl implements Writer {
    @Override
    public void writeToFile(List<String> report, String outputFilePathname) {
        File file = new File(outputFilePathname);
        try {
            Files.write(file.toPath(), report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write file", e);
        }
    }
}

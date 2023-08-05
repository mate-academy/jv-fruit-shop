package core.basesyntax.impl;

import static java.nio.file.Path.of;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeToFile(List<String> data, String outputPath) {
        try {
            for (int i = 0; i < data.size(); i++) {
                Files.writeString(of(outputPath), data.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + outputPath, e);
        }
    }
}

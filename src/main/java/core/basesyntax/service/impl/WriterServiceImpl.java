package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public boolean writeToFile(String filePath, String info) {
        File file = new File(filePath);
        try {
            Files.write(file.toPath(), List.of(info));
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
        return true;
    }
}

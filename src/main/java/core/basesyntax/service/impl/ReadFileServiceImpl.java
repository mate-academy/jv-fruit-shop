package core.basesyntax.service.impl;

import core.basesyntax.service.ReadFileService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadFileServiceImpl implements ReadFileService {
    @Override
    public List<String> getLineString(String pathFile) {
        try {
            return Files.readAllLines(new File(pathFile).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + pathFile, e);
        }
    }
}

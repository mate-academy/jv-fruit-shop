package core.basesyntax.service.imp;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterServiceImp implements WriterService {
    @Override
    public void writeToFile(List<String> lines, Path path) {
        try {
            Files.write(path,lines);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write file " + path, e);
        }
    }
}

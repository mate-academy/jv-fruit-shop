package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public interface FileReader {
    public List<String> readToFile(String pathToFile);
}

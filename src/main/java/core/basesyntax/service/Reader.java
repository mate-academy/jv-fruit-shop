package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface Reader {
    List<String> read(String filePath);
}

package core.basesyntax.dao;

import java.io.File;
import java.util.List;

public interface FileReader {
    List<String> get(File fromFileName);
}

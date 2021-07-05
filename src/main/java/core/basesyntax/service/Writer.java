package core.basesyntax.service;

import java.nio.file.Path;
import java.util.Map;

public interface Writer {
    boolean write(String report, String path);
}

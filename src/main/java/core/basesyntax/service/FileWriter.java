package core.basesyntax.service;

import java.util.List;

public interface FileWriter {
    public void write(List<String> lines, String path);
}

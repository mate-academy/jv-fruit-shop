package core.basesyntax.service;

import java.util.List;

public interface FileWriterCsv {
    void write(String fileName, List<String> report);
}

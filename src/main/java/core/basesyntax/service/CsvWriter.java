package core.basesyntax.service;

import java.io.File;

public interface CsvWriter {
    File write(String content, String filePath);
}

package core.basesyntax.service;

import java.io.File;

public interface Writer {
    File write(String content, String filePath);
}

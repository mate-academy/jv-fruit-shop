package core.basesyntax.service;

import java.io.File;

public interface WriterService {
    File writeToFile(String report, String fileName);
}

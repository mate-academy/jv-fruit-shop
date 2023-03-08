package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface ReadWriteOperations {
    List<String> readInfoFromFile(File inputFile);

    File writeReport(String data);
}

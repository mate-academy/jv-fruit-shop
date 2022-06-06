package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface MyFileReader {
    List<String> getDryInfo(File file);
}

package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface StorageReadService {
    List<String> readData(File file);
}

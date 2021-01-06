package core.basesyntax.service;

import java.util.List;

public interface FilesReader {
    List<String[]> read(String fileName);
}

package core.basesyntax.service;

import java.util.List;

public interface FileService {
    void write(String data, String fileName);

    List<String> read(String fileName);
}

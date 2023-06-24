package core.basesyntax.service.nio;

import java.util.List;

public interface FileService {
    List<String> read(String path);

    void write(String path, String report);
}

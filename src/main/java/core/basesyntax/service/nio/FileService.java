package core.basesyntax.service.nio;

import java.util.List;

public interface FileService {
    List<String> read(String pathFromRepository);

    void write(String string, String path);
}

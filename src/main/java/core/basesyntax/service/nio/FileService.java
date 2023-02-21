package core.basesyntax.service.nio;

import java.util.List;
import java.util.Map;

public interface FileService {
    List<String> read(String pathFromRepository);

    void write(String path, Map<String,Integer> map);
}

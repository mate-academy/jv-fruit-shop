package core.basesyntax.filereader;

import java.util.List;

public interface FileReaderService {
    List<String> read(String path);
}

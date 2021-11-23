package core.basesyntax.service.file.input;

import java.util.List;

public interface Reader {
    List<String> read(String filePath);
}

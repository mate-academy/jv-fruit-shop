package core.basesyntax.services.fileprocessing;

import java.util.List;

public interface Reader {
    List<String> readFile(String filename);
}

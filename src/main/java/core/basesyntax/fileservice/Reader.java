package core.basesyntax.fileservice;

import java.util.List;

public interface Reader {
    List<String> readFromFile(String source);
}

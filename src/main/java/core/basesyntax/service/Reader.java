package core.basesyntax.service;

import java.util.List;

public interface Reader {
    List<String> readFile(String path);
}

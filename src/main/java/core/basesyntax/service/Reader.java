package core.basesyntax.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Reader {
    List<String> read(String path);
}

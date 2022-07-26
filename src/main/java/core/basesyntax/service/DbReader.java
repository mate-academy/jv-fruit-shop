package core.basesyntax.service;

import java.util.List;

public interface DbReader {

    List<String[]> read(String path);

}

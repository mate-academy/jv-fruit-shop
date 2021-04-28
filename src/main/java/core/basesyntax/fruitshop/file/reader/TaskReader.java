package core.basesyntax.fruitshop.file.reader;

import java.util.Map;

public interface TaskReader {
    Map<String, Integer> readFile(String fromFile);
}

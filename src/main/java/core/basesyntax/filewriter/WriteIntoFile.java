package core.basesyntax.filewriter;

import java.util.Map;
import java.util.Set;

public interface WriteIntoFile {
    void writeInFile(Set<Map.Entry<String, Integer>> entries, String toFile);
}

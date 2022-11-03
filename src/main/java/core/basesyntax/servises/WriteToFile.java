package core.basesyntax.servises;

import java.util.HashMap;

public interface WriteToFile {
    void addToFile(String path, HashMap<String, Integer> storage);
}

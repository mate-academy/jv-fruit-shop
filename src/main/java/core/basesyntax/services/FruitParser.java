package core.basesyntax.services;

import java.util.List;

public interface FruitParser {
    List<List<String>> readFile(String path);
}

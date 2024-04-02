package core.basesyntax.service;

import java.util.Map;

public interface ReadDataLogic {
    Map<String, Integer> readDataFromFile(String path);
}

package myfirstproject.service;

import java.util.Map;
import myfirstproject.model.Fruit;

public interface WriteFile {
    void writeToFile(String path, Map<Fruit, Integer> map);
}
